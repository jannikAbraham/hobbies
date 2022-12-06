package de.jannik.hobbies.service;

import java.util.List;

public interface EntityService <Entity>
{
  List<Entity> findAll();

  Entity saveOrUpdate(Entity entity);

  void delete(Entity entity);
}
