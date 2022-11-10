package de.jannik.hobbies.model.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long countryID;

  @NotNull
  private String countryCode;

  @OneToMany(mappedBy = "country")
  private Set<User> user;

  public Country() {}
  public Long getId()
  {
    return countryID;
  }

  public void setId(Long id)
  {
    this.countryID = id;
  }

  public String getCountryCode()
  {
    return countryCode;
  }

  public void setCountryCode(String countryCode)
  {
    this.countryCode = countryCode;
  }
}
