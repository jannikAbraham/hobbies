package de.jannik.hobbies.service;

import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public User save(User user)
  {
    return userDao.save(user);
  }

  public void  deleteById(Long id)
  {
    userDao.deleteById(id);
  }
}
