package de.jannik.hobbies.service;

import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
  //@autowired dependency Injection
  @Autowired
  private UserDao userDao;

  public List<User> findAll()
  {
    return userDao.findAll();
  }


  public Optional<User> save(User user)
  {
    if (user.getId() == null)
    {

      if(user.getCountry() != null)
        return Optional.of(userDao.save(user));
    }

    //check if user exist by email
    return Optional.empty();
  }

  public void deleteById(Long id)
  {
    userDao.deleteById(id);
  }

  public Optional<User> findById(Long id)
  {
    return userDao.findById(id);
  }

  public Optional<User> update(User user)
  {
    if (user.getId() != null)
    {
      return Optional.of(userDao.save(user));
    }
    return Optional.empty();
  }

  public List<User> findAllByCountryId(Long id)
  {
    if(id != null)
    {
      return userDao.findAllByCountryId(id);
    }
    return null;
  }

  public List<User> findAllByHobbyId(Long id)
  {
    if(id != null)
    {
      return userDao.findAllByHobbyId(id);
    }
    return null;
  }
}
