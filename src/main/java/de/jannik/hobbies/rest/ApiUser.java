package de.jannik.hobbies.rest;

import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/user")
public class ApiUser
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
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable Long id)
  {
    if(userService.findById(id)== null)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    userService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(true);
  }
  @PatchMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody User partialUpdate ,@PathVariable Long id)
  {

    return null;
  }
  @GetMapping("/{id}")
  public ResponseEntity<User> read(@PathVariable Long id)
  {
    User read = userService.findById(id);
    if(read== null)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    return ResponseEntity.status(HttpStatus.OK).body(read);
  }

}
