package de.jannik.hobbies.api.model.dto;

import com.sun.istack.NotNull;
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.model.enums.Gender;
import org.apache.catalina.LifecycleState;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDto
{
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  @Email(message = "not valid email")
  private String email;

  private LocalDate birthday;
  private Gender gender;
  private String countryCode;

  private Set<Hobby> hobbies = new HashSet<>();

  public UserDto()
  {
  }

  public UserDto(Long id, String name, String email, LocalDate birthday, Gender gender, String countryCode,Set<Hobby> hobbies)
  {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birthday = birthday;
    this.gender = gender;
    this.countryCode = countryCode;
    this.hobbies = hobbies;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public LocalDate getBirthday()
  {
    return birthday;
  }

  public void setBirthday(LocalDate birthday)
  {
    this.birthday = birthday;
  }

  public Gender getGender()
  {
    return gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  public String getCountryCode()
  {
    return countryCode;
  }

  public void setCountryCode(String countryCode)
  {
    this.countryCode = countryCode;
  }

  public Set<Hobby> getHobbies()
  {
    return hobbies;
  }

  public void setHobbies(Set<Hobby> hobbies)
  {
    this.hobbies = hobbies;
  }
}
