package com.codecombat.api.client.users.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = UpdateSubscriptionRequest.Builder.class
)
public final class UpdateSubscriptionRequest {
  private final String ends;

  private int _cachedHashCode;

  UpdateSubscriptionRequest(String ends) {
    this.ends = ends;
  }

  @JsonProperty("ends")
  public String getEnds() {
    return ends;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpdateSubscriptionRequest && equalTo((UpdateSubscriptionRequest) other);
  }

  private boolean equalTo(UpdateSubscriptionRequest other) {
    return ends.equals(other.ends);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ends);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpdateSubscriptionRequest{" + "ends: " + ends + "}";
  }

  public static EndsStage builder() {
    return new Builder();
  }

  public interface EndsStage {
    _FinalStage ends(String ends);

    Builder from(UpdateSubscriptionRequest other);
  }

  public interface _FinalStage {
    UpdateSubscriptionRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EndsStage, _FinalStage {
    private String ends;

    private Builder() {
    }

    @Override
    public Builder from(UpdateSubscriptionRequest other) {
      ends(other.getEnds());
      return this;
    }

    @Override
    @JsonSetter("ends")
    public _FinalStage ends(String ends) {
      this.ends = ends;
      return this;
    }

    @Override
    public UpdateSubscriptionRequest build() {
      return new UpdateSubscriptionRequest(ends);
    }
  }
}
