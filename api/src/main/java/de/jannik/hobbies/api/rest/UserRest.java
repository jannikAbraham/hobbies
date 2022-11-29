package de.jannik.hobbies.api.rest;

import de.jannik.hobbies.api.model.mapper.dto.UserDto;
import de.jannik.hobbies.api.model.mapper.dto.UserHobbyDto;
import de.jannik.hobbies.api.service.UserRestService;
import de.jannik.hobbies.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserRest
{
  @Autowired
  UserRestService userRestService;
  @Autowired
  CountryService countryService;

  @PostMapping
  public ResponseEntity<UserDto> create(@Valid
  @RequestBody
  UserDto userDto)
  {
    return userRestService.save(userDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(
      @PathVariable
      Long id)
  {
    return userRestService.delete(id);
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(
      @RequestBody
      UserDto userDto)
  {
    return userRestService.update(userDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> read(
      @PathVariable
      Long id)
  {
    return userRestService.findById(id);
  }

  @GetMapping("/all")
  public ResponseEntity<List<UserDto>> findAll()
  {
    return userRestService.findAll();
  }

  @GetMapping("/country/{id}")
  public ResponseEntity<List<UserDto>> findUsersByCountry(
      @PathVariable
      Long id)
  {
    return userRestService.findAllByCountry(id);
  }

  @PostMapping("/user/hobby")
  public ResponseEntity<UserDto> saveUserHobbies(
      @RequestBody
      UserHobbyDto userHobbyDto)
  {
    return userRestService.saveUserHobbies(userHobbyDto);
  }

}
