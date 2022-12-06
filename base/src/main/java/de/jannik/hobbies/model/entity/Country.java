package de.jannik.hobbies.model.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Country
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Column(unique = true)
  private String code;

  @NotNull
  private String helperText;





  public Country()
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

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
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
