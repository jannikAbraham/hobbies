package de.jannik.hobbies.service;

import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.repository.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService
{
  @Autowired
  private CountryDao countryDao;

  public List<Country> findAll()
  {
    return countryDao.findAll();
  }


}
