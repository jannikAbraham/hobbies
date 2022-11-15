package de.jannik.hobbies.api.rest;

import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/country")
public class CountryRest
{
  @Autowired
  CountryService countryService;

  @GetMapping("all")
  public ResponseEntity<List<Country>> readAll()
  {
    List<Country> all = countryService.findAll();
    if (all.isEmpty())
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(all);
    return ResponseEntity.status(HttpStatus.OK).body(all);
  }

//  @PutMapping("/create")
//  public ResponseEntity<Optional<Country>> crate(
//      @RequestBody
//      Country country)
//  {
//    Optional<Country> save = countryService.save(country);
//    return ResponseEntity.status(HttpStatus.OK).body(save);
//  }
}
