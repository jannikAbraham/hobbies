package de.jannik.hobbies.repository;

import de.jannik.hobbies.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao extends JpaRepository<Country,Long>
{

}
