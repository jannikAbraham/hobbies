package de.jannik.hobbies.api.rest;

import de.jannik.hobbies.model.entity.User;
import org.springframework.web.bind.annotation.*;

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
