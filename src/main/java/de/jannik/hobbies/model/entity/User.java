package de.jannik.hobbies.model.entity;

import com.sun.istack.NotNull;
import de.jannik.hobbies.model.enums.Gender;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
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
  @CreatedDate
  private LocalDateTime joinTime;

  @NotNull
  private boolean active = true;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "hobby_user",joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
             inverseJoinColumns = {@JoinColumn(name = "hobby_id",referencedColumnName = "id")})
  private Set<Hobby> hobbies = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "country_id",nullable = false)
  private Country countries;

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

  public boolean isActive()
  {
    return active;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public Set<Hobby> getHobbies()
  {
    return hobbies;
  }

  public void setHobbies(Set<Hobby> hobbies)
  {
    this.hobbies = hobbies;
  }

  @Override
  public String toString()
  {
    return "User{" + "id=" + id + ", name='" + name + '\'' + ", eMail='" + eMail + '\'' + ", birthday=" + birthday + ", gender=" + gender
        + ", joinTime=" + joinTime + ", active=" + active + '}';
  }
}
