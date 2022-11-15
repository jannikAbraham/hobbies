package de.jannik.hobbies.api.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserHobbyDto
{
  @NotBlank
  @NotNull
  private Long hobbyId;

  @NotNull
  @NotBlank
  private Long userId;

  public UserHobbyDto()
  {
  }

  public UserHobbyDto(Long hobbyId, Long UserId)
  {
    this.hobbyId = hobbyId;
    this.userId = UserId;
  }

  public Long getHobbyId()
  {
    return hobbyId;
  }

  public void setHobbyId(Long hobbyId)
  {
    this.hobbyId = hobbyId;
  }

  public Long getUserId()
  {
    return userId;
  }

  public void setUserId(Long userId)
  {
    this.userId = userId;
  }
}
