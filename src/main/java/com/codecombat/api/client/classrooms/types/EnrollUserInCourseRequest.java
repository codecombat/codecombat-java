package com.codecombat.api.client.classrooms.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = EnrollUserInCourseRequest.Builder.class
)
public final class EnrollUserInCourseRequest {
  private final String userId;

  private int _cachedHashCode;

  EnrollUserInCourseRequest(String userId) {
    this.userId = userId;
  }

  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EnrollUserInCourseRequest && equalTo((EnrollUserInCourseRequest) other);
  }

  private boolean equalTo(EnrollUserInCourseRequest other) {
    return userId.equals(other.userId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.userId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "EnrollUserInCourseRequest{" + "userId: " + userId + "}";
  }

  public static UserIdStage builder() {
    return new Builder();
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);

    Builder from(EnrollUserInCourseRequest other);
  }

  public interface _FinalStage {
    EnrollUserInCourseRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UserIdStage, _FinalStage {
    private String userId;

    private Builder() {
    }

    @Override
    public Builder from(EnrollUserInCourseRequest other) {
      userId(other.getUserId());
      return this;
    }

    @Override
    @JsonSetter("userId")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    @Override
    public EnrollUserInCourseRequest build() {
      return new EnrollUserInCourseRequest(userId);
    }
  }
}
