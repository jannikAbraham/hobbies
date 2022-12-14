package de.jannik.hobbies.model.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "hobby")
public class Hobby
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull
  @Column(unique = true)
  private String name;

  @NotNull
  private String helperText;

  public Hobby()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getHelperText()
  {
    return helperText;
  }

  public void setHelperText(String helperText)
  {
    this.helperText = helperText;
  }
}
