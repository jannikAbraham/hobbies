package de.jannik.hobbies.api.model.mapper;

import de.jannik.hobbies.api.model.mapper.dto.UserDto;
import de.jannik.hobbies.model.DtoEntityMapper;
import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.User;

public class UserMapper implements DtoEntityMapper<User, UserDto>
{
  @Override
  public User convertToEntity(UserDto dto)
  {
    Country country = new Country();
    country.setCode(dto.getCountryCode());

    User user = new User();
    user.setId(dto.getId());
    user.setName(dto.getName());
    user.setBirthday(dto.getBirthday());
    user.setGender(dto.getGender());
    user.seteMail(dto.getEmail());
    user.setCountry(country);
    user.setHobbies(dto.getHobbies());
    return user;
  }

  @Override
  public UserDto convertToDto(User user)
  {
    // lookup ternary operator
    String countryCode = user.getCountry() == null ? null : user.getCountry().getCode();
    return new UserDto(user.getId(), user.getName(), user.geteMail(), user.getBirthday(), user.getGender(), countryCode, user.getHobbies());
  }
}
