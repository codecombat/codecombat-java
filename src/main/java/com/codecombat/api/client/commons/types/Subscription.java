package com.codecombat.api.client.commons.types;

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
    builder = Subscription.Builder.class
)
public final class Subscription {
  private final Optional<String> ends;

  private final Optional<Boolean> active;

  private int _cachedHashCode;

  Subscription(Optional<String> ends, Optional<Boolean> active) {
    this.ends = ends;
    this.active = active;
  }

  @JsonProperty("ends")
  public Optional<String> getEnds() {
    return ends;
  }

  @JsonProperty("active")
  public Optional<Boolean> getActive() {
    return active;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Subscription && equalTo((Subscription) other);
  }

  private boolean equalTo(Subscription other) {
    return ends.equals(other.ends) && active.equals(other.active);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ends, this.active);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Subscription{" + "ends: " + ends + ", active: " + active + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> ends = Optional.empty();

    private Optional<Boolean> active = Optional.empty();

    private Builder() {
    }

    public Builder from(Subscription other) {
      ends(other.getEnds());
      active(other.getActive());
      return this;
    }

    @JsonSetter(
        value = "ends",
        nulls = Nulls.SKIP
    )
    public Builder ends(Optional<String> ends) {
      this.ends = ends;
      return this;
    }

    public Builder ends(String ends) {
      this.ends = Optional.of(ends);
      return this;
    }

    @JsonSetter(
        value = "active",
        nulls = Nulls.SKIP
    )
    public Builder active(Optional<Boolean> active) {
      this.active = active;
      return this;
    }

    public Builder active(Boolean active) {
      this.active = Optional.of(active);
      return this;
    }

    public Subscription build() {
      return new Subscription(ends, active);
    }
  }
}
