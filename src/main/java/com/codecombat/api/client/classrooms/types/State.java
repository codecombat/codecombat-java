package com.codecombat.api.client.classrooms.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = State.Builder.class
)
public final class State {
  private final Optional<Boolean> complete;

  private int _cachedHashCode;

  State(Optional<Boolean> complete) {
    this.complete = complete;
  }

  @JsonProperty("complete")
  public Optional<Boolean> getComplete() {
    return complete;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof State && equalTo((State) other);
  }

  private boolean equalTo(State other) {
    return complete.equals(other.complete);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.complete);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "State{" + "complete: " + complete + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Boolean> complete = Optional.empty();

    private Builder() {
    }

    public Builder from(State other) {
      complete(other.getComplete());
      return this;
    }

    @JsonSetter(
        value = "complete",
        nulls = Nulls.SKIP
    )
    public Builder complete(Optional<Boolean> complete) {
      this.complete = complete;
      return this;
    }

    public Builder complete(Boolean complete) {
      this.complete = Optional.of(complete);
      return this;
    }

    public State build() {
      return new State(complete);
    }
  }
}
