package de.jannik.hobbies.api.rest;

import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hobby")
public class HobbyRest
{
  @Autowired
  HobbyService hobbyService;

  @GetMapping("/all")
  public ResponseEntity<List<Hobby>> readAll()
  {
    List<Hobby> all = hobbyService.findAll();
    if (all.isEmpty())
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(all);
    return ResponseEntity.status(HttpStatus.OK).body(all);
  }

  @PutMapping("/create")
  public ResponseEntity<Hobby> crateHobby(@RequestBody Hobby hobby)
  {
    Hobby save = hobbyService.save(hobby);
    return ResponseEntity.status(HttpStatus.OK).body(hobby);
  }

}
