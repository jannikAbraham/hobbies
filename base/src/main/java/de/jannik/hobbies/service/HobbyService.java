package de.jannik.hobbies.service;

import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.repository.HobbyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HobbyService implements EntityService<Hobby>
{
  @Autowired
  private HobbyDao hobbyDao;

  public List<Hobby> findAll()
  {
    return hobbyDao.findAll();
  }

  @Override
  public Hobby saveOrUpdate(Hobby hobby)
  {
    return null;
  }

  @Override
  public void delete(Hobby hobby)
  {

  }

  public Hobby save(Hobby hobby)
  {
    return hobbyDao.save(hobby);
  }

  public Optional<Hobby> findById(Long id){ return hobbyDao.findById(id);}

}
