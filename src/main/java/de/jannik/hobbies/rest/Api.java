package de.jannik.hobbies.rest;

import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.model.enums.Gender;
import de.jannik.hobbies.service.UserService;
import org.hibernate.id.insert.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("api/user")
public class Api
{
  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user)
  {
    User save = userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(save);
  }
  //toDo: warp this in a response entity
  @GetMapping("/{id}")
  public void delete(@PathVariable Long id)
  {
    userService.deleteById(id);
  }
  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable Long id)
  {

    return null;
  }

}
