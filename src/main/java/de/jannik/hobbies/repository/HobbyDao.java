package de.jannik.hobbies.repository;

import de.jannik.hobbies.model.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface HobbyDao extends JpaRepository<Hobby,Long>
{

}
