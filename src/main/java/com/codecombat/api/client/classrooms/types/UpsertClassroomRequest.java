package com.codecombat.api.client.classrooms.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = UpsertClassroomRequest.Builder.class
)
public final class UpsertClassroomRequest {
  private final String code;

  private final String userId;

  private final Optional<Double> retMemberLimit;

  private int _cachedHashCode;

  UpsertClassroomRequest(String code, String userId, Optional<Double> retMemberLimit) {
    this.code = code;
    this.userId = userId;
    this.retMemberLimit = retMemberLimit;
  }

  /**
   * @return The code for joining this classroom
   */
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  /**
   * @return The <code>_id</code> or <code>slug</code> of the user to add to the class.
   */
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  /**
   * @return limit the return number of members for the classroom, the default value is 1000
   */
  @JsonProperty("retMemberLimit")
  public Optional<Double> getRetMemberLimit() {
    return retMemberLimit;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpsertClassroomRequest && equalTo((UpsertClassroomRequest) other);
  }

  private boolean equalTo(UpsertClassroomRequest other) {
    return code.equals(other.code) && userId.equals(other.userId) && retMemberLimit.equals(other.retMemberLimit);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.code, this.userId, this.retMemberLimit);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpsertClassroomRequest{" + "code: " + code + ", userId: " + userId + ", retMemberLimit: " + retMemberLimit + "}";
  }

  public static CodeStage builder() {
    return new Builder();
  }

  public interface CodeStage {
    UserIdStage code(String code);

    Builder from(UpsertClassroomRequest other);
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);
  }

  public interface _FinalStage {
    UpsertClassroomRequest build();

    _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

    _FinalStage retMemberLimit(Double retMemberLimit);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements CodeStage, UserIdStage, _FinalStage {
    private String code;

    private String userId;

    private Optional<Double> retMemberLimit = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(UpsertClassroomRequest other) {
      code(other.getCode());
      userId(other.getUserId());
      retMemberLimit(other.getRetMemberLimit());
      return this;
    }

    /**
     * <p>The code for joining this classroom</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("code")
    public UserIdStage code(String code) {
      this.code = code;
      return this;
    }

    /**
     * <p>The <code>_id</code> or <code>slug</code> of the user to add to the class.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("userId")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    /**
     * <p>limit the return number of members for the classroom, the default value is 1000</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage retMemberLimit(Double retMemberLimit) {
      this.retMemberLimit = Optional.of(retMemberLimit);
      return this;
    }

    @Override
    @JsonSetter(
        value = "retMemberLimit",
        nulls = Nulls.SKIP
    )
    public _FinalStage retMemberLimit(Optional<Double> retMemberLimit) {
      this.retMemberLimit = retMemberLimit;
      return this;
    }

    @Override
    public UpsertClassroomRequest build() {
      return new UpsertClassroomRequest(code, userId, retMemberLimit);
    }
  }
}
