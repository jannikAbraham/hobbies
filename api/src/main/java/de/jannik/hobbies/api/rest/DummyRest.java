package de.jannik.hobbies.api.rest;

import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.model.enums.Gender;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("api/dummy")
public class DummyRest
{

  @PostMapping("say-hi")
  public void print(@RequestBody User user)
  {
    System.out.println(user.toString());
    System.out.println("hello");
  }
}
