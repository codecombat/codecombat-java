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
    builder = PlayStats.Builder.class
)
public final class PlayStats {
  private final Optional<Double> gamesCompleted;

  private final Optional<Double> playtime;

  private int _cachedHashCode;

  PlayStats(Optional<Double> gamesCompleted, Optional<Double> playtime) {
    this.gamesCompleted = gamesCompleted;
    this.playtime = playtime;
  }

  @JsonProperty("gamesCompleted")
  public Optional<Double> getGamesCompleted() {
    return gamesCompleted;
  }

  /**
   * @return Total play time in seconds
   */
  @JsonProperty("playtime")
  public Optional<Double> getPlaytime() {
    return playtime;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PlayStats && equalTo((PlayStats) other);
  }

  private boolean equalTo(PlayStats other) {
    return gamesCompleted.equals(other.gamesCompleted) && playtime.equals(other.playtime);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gamesCompleted, this.playtime);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PlayStats{" + "gamesCompleted: " + gamesCompleted + ", playtime: " + playtime + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Double> gamesCompleted = Optional.empty();

    private Optional<Double> playtime = Optional.empty();

    private Builder() {
    }

    public Builder from(PlayStats other) {
      gamesCompleted(other.getGamesCompleted());
      playtime(other.getPlaytime());
      return this;
    }

    @JsonSetter(
        value = "gamesCompleted",
        nulls = Nulls.SKIP
    )
    public Builder gamesCompleted(Optional<Double> gamesCompleted) {
      this.gamesCompleted = gamesCompleted;
      return this;
    }

    public Builder gamesCompleted(Double gamesCompleted) {
      this.gamesCompleted = Optional.of(gamesCompleted);
      return this;
    }

    @JsonSetter(
        value = "playtime",
        nulls = Nulls.SKIP
    )
    public Builder playtime(Optional<Double> playtime) {
      this.playtime = playtime;
      return this;
    }

    public Builder playtime(Double playtime) {
      this.playtime = Optional.of(playtime);
      return this;
    }

    public PlayStats build() {
      return new PlayStats(gamesCompleted, playtime);
    }
  }
}
