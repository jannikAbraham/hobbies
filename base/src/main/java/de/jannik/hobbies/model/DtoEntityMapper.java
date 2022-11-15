package de.jannik.hobbies.model;

public interface DtoEntityMapper<E, D>
{
  E convertToEntity(D d);
  D convertToDto(E e);
}
