package de.jannik.hobbies.service;

import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.repository.CountryDao;
import de.jannik.hobbies.util.CountryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService
{
  @Autowired
  private CountryDao countryDao;

  public List<Country> findAll()
  {
    return countryDao.findAll();
  }

  public Optional<Country> findByCode(String code)
  {
    return countryDao.findByCode(code);
  }

  public Optional<Country> save(Country country)
  {
    //make sure id is null otherwise its going to update the entity
    if (country.getId() != null)
      return Optional.empty();
    //making sure before saving country code is valid
    if (!CountryUtil.validate(country.getCode()))
      return Optional.empty();

    // checking if the country already exists
    Optional<Country> byCode = findByCode(country.getCode());
    if (byCode.isPresent())
      return byCode; // if found return what we have already

    // otherwise create a new country and return
    return Optional.of(countryDao.save(country));
  }

}
