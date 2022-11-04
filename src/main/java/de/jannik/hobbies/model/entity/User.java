package de.jannik.hobbies.model.entity;

import com.sun.istack.NotNull;
import de.jannik.hobbies.model.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String eMail;

  private Date birthday;
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @NotNull
  private LocalDateTime joinTime;

  public User()
  {
  }

  public User(Long id, String name, String eMail, Date birthday, Gender gender, LocalDateTime joinTime, Boolean active)
  {
    this.id = id;
    this.name = name;
    this.eMail = eMail;
    this.birthday = birthday;
    this.gender = gender;
    this.joinTime = joinTime;
    this.active = active;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String geteMail()
  {
    return eMail;
  }

  public void seteMail(String eMail)
  {
    this.eMail = eMail;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  public Gender getGender()
  {
    return gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  public LocalDateTime getJoinTime()
  {
    return joinTime;
  }

  public void setJoinTime(LocalDateTime joinTime)
  {
    this.joinTime = joinTime;
  }

  public Boolean getActive()
  {
    return active;
  }

  public void setActive(Boolean active)
  {
    this.active = active;
  }

  private Boolean active;

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  @Override
  public String toString()
  {
    return "User{" + "id=" + id + ", name='" + name + '\'' + ", eMail='" + eMail + '\'' + ", birthday=" + birthday + ", gender=" + gender
        + ", joinTime=" + joinTime + ", active=" + active + '}';
  }
}
