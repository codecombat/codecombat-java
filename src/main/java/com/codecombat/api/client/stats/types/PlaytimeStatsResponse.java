package com.codecombat.api.client.stats.types;

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
    builder = PlaytimeStatsResponse.Builder.class
)
public final class PlaytimeStatsResponse {
  private final Optional<Double> playTime;

  private final Optional<Double> gamesPlayed;

  private int _cachedHashCode;

  PlaytimeStatsResponse(Optional<Double> playTime, Optional<Double> gamesPlayed) {
    this.playTime = playTime;
    this.gamesPlayed = gamesPlayed;
  }

  /**
   * @return Total play time in seconds
   */
  @JsonProperty("playTime")
  public Optional<Double> getPlayTime() {
    return playTime;
  }

  /**
   * @return Number of levels played
   */
  @JsonProperty("gamesPlayed")
  public Optional<Double> getGamesPlayed() {
    return gamesPlayed;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PlaytimeStatsResponse && equalTo((PlaytimeStatsResponse) other);
  }

  private boolean equalTo(PlaytimeStatsResponse other) {
    return playTime.equals(other.playTime) && gamesPlayed.equals(other.gamesPlayed);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.playTime, this.gamesPlayed);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PlaytimeStatsResponse{" + "playTime: " + playTime + ", gamesPlayed: " + gamesPlayed + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Double> playTime = Optional.empty();

    private Optional<Double> gamesPlayed = Optional.empty();

    private Builder() {
    }

    public Builder from(PlaytimeStatsResponse other) {
      playTime(other.getPlayTime());
      gamesPlayed(other.getGamesPlayed());
      return this;
    }

    @JsonSetter(
        value = "playTime",
        nulls = Nulls.SKIP
    )
    public Builder playTime(Optional<Double> playTime) {
      this.playTime = playTime;
      return this;
    }

    public Builder playTime(Double playTime) {
      this.playTime = Optional.of(playTime);
      return this;
    }

    @JsonSetter(
        value = "gamesPlayed",
        nulls = Nulls.SKIP
    )
    public Builder gamesPlayed(Optional<Double> gamesPlayed) {
      this.gamesPlayed = gamesPlayed;
      return this;
    }

    public Builder gamesPlayed(Double gamesPlayed) {
      this.gamesPlayed = Optional.of(gamesPlayed);
      return this;
    }

    public PlaytimeStatsResponse build() {
      return new PlaytimeStatsResponse(playTime, gamesPlayed);
    }
  }
}
