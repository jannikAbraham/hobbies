package de.jannik.hobbies.repository;

import de.jannik.hobbies.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long>
{

  List<User> findAllByCountryId(Long id);



}
