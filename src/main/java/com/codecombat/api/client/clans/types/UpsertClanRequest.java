package com.codecombat.api.client.clans.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = UpsertClanRequest.Builder.class
)
public final class UpsertClanRequest {
  private final String userId;

  private int _cachedHashCode;

  UpsertClanRequest(String userId) {
    this.userId = userId;
  }

  /**
   * @return The <code>_id</code> or <code>slug</code> of the user to add to the clan.
   */
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpsertClanRequest && equalTo((UpsertClanRequest) other);
  }

  private boolean equalTo(UpsertClanRequest other) {
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
    return "UpsertClanRequest{" + "userId: " + userId + "}";
  }

  public static UserIdStage builder() {
    return new Builder();
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);

    Builder from(UpsertClanRequest other);
  }

  public interface _FinalStage {
    UpsertClanRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UserIdStage, _FinalStage {
    private String userId;

    private Builder() {
    }

    @Override
    public Builder from(UpsertClanRequest other) {
      userId(other.getUserId());
      return this;
    }

    /**
     * <p>The <code>_id</code> or <code>slug</code> of the user to add to the clan.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("userId")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    @Override
    public UpsertClanRequest build() {
      return new UpsertClanRequest(userId);
    }
  }
}
