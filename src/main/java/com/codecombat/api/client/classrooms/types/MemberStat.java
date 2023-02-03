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
    builder = MemberStat.Builder.class
)
public final class MemberStat {
  private final Optional<String> id;

  private final Optional<PlayStats> stats;

  private int _cachedHashCode;

  MemberStat(Optional<String> id, Optional<PlayStats> stats) {
    this.id = id;
    this.stats = stats;
  }

  @JsonProperty("_id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("stats")
  public Optional<PlayStats> getStats() {
    return stats;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MemberStat && equalTo((MemberStat) other);
  }

  private boolean equalTo(MemberStat other) {
    return id.equals(other.id) && stats.equals(other.stats);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.stats);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MemberStat{" + "id: " + id + ", stats: " + stats + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> id = Optional.empty();

    private Optional<PlayStats> stats = Optional.empty();

    private Builder() {
    }

    public Builder from(MemberStat other) {
      id(other.getId());
      stats(other.getStats());
      return this;
    }

    @JsonSetter(
        value = "_id",
        nulls = Nulls.SKIP
    )
    public Builder id(Optional<String> id) {
      this.id = id;
      return this;
    }

    public Builder id(String id) {
      this.id = Optional.of(id);
      return this;
    }

    @JsonSetter(
        value = "stats",
        nulls = Nulls.SKIP
    )
    public Builder stats(Optional<PlayStats> stats) {
      this.stats = stats;
      return this;
    }

    public Builder stats(PlayStats stats) {
      this.stats = Optional.of(stats);
      return this;
    }

    public MemberStat build() {
      return new MemberStat(id, stats);
    }
  }
}
