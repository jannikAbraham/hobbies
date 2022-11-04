package de.jannik.hobbies.rest;

import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.model.enums.Gender;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("api/dummy")
public class DummyRest
{
  @GetMapping("say-hi")
  public User hello()
  {
    User user = new User(1L,"Jannik","jannikemail",new Date(), Gender.MALE, LocalDateTime.now(),true);
    return user;
  }

  @PostMapping("say-hi")
  public void print(@RequestBody User user)
  {
    System.out.println(user.toString());
    System.out.println("hello");
  }
}
