package de.jannik.hobbies.service;

import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.repository.HobbyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService
{
  @Autowired
  private HobbyDao hobbyDao;

  public List<Hobby> findAll()
  {
    return hobbyDao.findAll();
  }

  public Hobby save(Hobby hobby)
  {
    return hobbyDao.save(hobby);
  }

}
