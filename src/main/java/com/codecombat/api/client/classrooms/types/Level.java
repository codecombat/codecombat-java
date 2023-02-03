package com.codecombat.api.client.classrooms.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Level.Builder.class
)
public final class Level {
  private final Optional<String> original;

  private int _cachedHashCode;

  Level(Optional<String> original) {
    this.original = original;
  }

  /**
   * @return The id for the level.
   */
  @JsonProperty("original")
  public Optional<String> getOriginal() {
    return original;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Level && equalTo((Level) other);
  }

  private boolean equalTo(Level other) {
    return original.equals(other.original);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.original);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Level{" + "original: " + original + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> original = Optional.empty();

    private Builder() {
    }

    public Builder from(Level other) {
      original(other.getOriginal());
      return this;
    }

    @JsonSetter(
        value = "original",
        nulls = Nulls.SKIP
    )
    public Builder original(Optional<String> original) {
      this.original = original;
      return this;
    }

    public Builder original(String original) {
      this.original = Optional.of(original);
      return this;
    }

    public Level build() {
      return new Level(original);
    }
  }
}
