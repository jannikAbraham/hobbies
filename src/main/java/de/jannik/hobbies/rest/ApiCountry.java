package de.jannik.hobbies.rest;

import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/country")
public class ApiCountry
{
  @Autowired
  CountryService countryService;

  @GetMapping("all")
  public ResponseEntity<List<Country>> readAll()
  {
    List<Country> all = countryService.findAll();
    if(all.isEmpty())
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(all);
    return ResponseEntity.status(HttpStatus.OK).body(all);
  }
}
