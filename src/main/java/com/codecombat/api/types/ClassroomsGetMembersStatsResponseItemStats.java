package com.codecombat.api.types;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClassroomsGetMembersStatsResponseItemStats.Builder.class)
public final class ClassroomsGetMembersStatsResponseItemStats {
    private final Optional<Double> gamesCompleted;

    private final Optional<Double> playtime;

    private ClassroomsGetMembersStatsResponseItemStats(Optional<Double> gamesCompleted, Optional<Double> playtime) {
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
        return other instanceof ClassroomsGetMembersStatsResponseItemStats
                && equalTo((ClassroomsGetMembersStatsResponseItemStats) other);
    }

    private boolean equalTo(ClassroomsGetMembersStatsResponseItemStats other) {
        return gamesCompleted.equals(other.gamesCompleted) && playtime.equals(other.playtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gamesCompleted, this.playtime);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Double> gamesCompleted = Optional.empty();

        private Optional<Double> playtime = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomsGetMembersStatsResponseItemStats other) {
            gamesCompleted(other.getGamesCompleted());
            playtime(other.getPlaytime());
            return this;
        }

        @JsonSetter(value = "gamesCompleted", nulls = Nulls.SKIP)
        public Builder gamesCompleted(Optional<Double> gamesCompleted) {
            this.gamesCompleted = gamesCompleted;
            return this;
        }

        public Builder gamesCompleted(Double gamesCompleted) {
            this.gamesCompleted = Optional.of(gamesCompleted);
            return this;
        }

        @JsonSetter(value = "playtime", nulls = Nulls.SKIP)
        public Builder playtime(Optional<Double> playtime) {
            this.playtime = playtime;
            return this;
        }

        public Builder playtime(Double playtime) {
            this.playtime = Optional.of(playtime);
            return this;
        }

        public ClassroomsGetMembersStatsResponseItemStats build() {
            return new ClassroomsGetMembersStatsResponseItemStats(gamesCompleted, playtime);
        }
    }
}
