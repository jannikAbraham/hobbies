package de.jannik.hobbies.api.service;

import de.jannik.hobbies.api.model.mapper.dto.UserDto;
import de.jannik.hobbies.api.model.mapper.dto.UserHobbyDto;
import de.jannik.hobbies.api.model.mapper.UserMapper;
import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.service.CountryService;
import de.jannik.hobbies.service.HobbyService;
import de.jannik.hobbies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRestService
{
  @Autowired
  private UserService userService;

  @Autowired
  private CountryService countryService;

  @Autowired
  private HobbyService hobbyService;

  private final UserMapper mapper = new UserMapper();

  public ResponseEntity<Boolean> delete(Long id)
  {
    if (userService.findById(id).isEmpty())
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    userService.deleteById(id);
    return ResponseEntity.ok(true);
  }

  public ResponseEntity<List<UserDto>> findAll()
  {
    List<UserDto> userDtos = userService.findAll().stream().map(mapper::convertToDto).toList();
    if (userDtos.isEmpty())
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userDtos);
    return ResponseEntity.ok(userDtos);
  }

  public ResponseEntity<UserDto> findById(Long id)
  {
    Optional<User> user = userService.findById(id);
    if (user.isEmpty())
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    return ResponseEntity.status(HttpStatus.OK).body(mapper.convertToDto(user.get()));
  }

  public ResponseEntity<UserDto> save(UserDto dto)
  {
    User entity = mapper.convertToEntity(dto);
    // set country
    Country givenCountry = entity.getCountry();
    // checking does this country already exist
    Optional<Country> fetchedCountry = countryService.save(givenCountry);
    if (fetchedCountry.isEmpty())
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    else
      entity.setCountry(fetchedCountry.get());

    //creating a new user
    Optional<User> newUser = userService.save(entity);
    if (newUser.isPresent())
      return ResponseEntity.status(HttpStatus.CREATED).body(mapper.convertToDto(newUser.get()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
  }

  public ResponseEntity<UserDto> update(UserDto dto)
  {
    save(dto);
    return ResponseEntity.status(HttpStatus.OK).body(dto);
  }

  public ResponseEntity<List<UserDto>> findAllByCountry(Long id)
  {
    List<UserDto> userDtos = userService.findAllByCountryId(id).stream().map(mapper::convertToDto).toList();
    if (userDtos.isEmpty())
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userDtos);
    return ResponseEntity.ok(userDtos);
  }

  public ResponseEntity<UserDto> saveUserHobbies(UserHobbyDto userHobbyDto)
  {
    if (userHobbyDto.getHobbyId() != null && userHobbyDto.getHobbyId() != null)
    {
      Optional<Hobby> foundHobby = hobbyService.findById(userHobbyDto.getHobbyId());
      Optional<User> foundUser = userService.findById(userHobbyDto.getUserId());

      if (foundUser.isPresent() && foundHobby.isPresent())
      {
        foundUser.get().getHobbies().add(foundHobby.get());
        Optional<User> updated = userService.update(foundUser.get());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.convertToDto(updated.get()));
      }
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
  }
}
