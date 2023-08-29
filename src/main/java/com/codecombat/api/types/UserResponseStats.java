package com.codecombat.api.types;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UserResponseStats.Builder.class)
public final class UserResponseStats {
    private final Optional<Double> gamesCompleted;

    private final Optional<Map<String, Double>> concepts;

    private final Optional<Double> playTime;

    private UserResponseStats(
            Optional<Double> gamesCompleted, Optional<Map<String, Double>> concepts, Optional<Double> playTime) {
        this.gamesCompleted = gamesCompleted;
        this.concepts = concepts;
        this.playTime = playTime;
    }

    @JsonProperty("gamesCompleted")
    public Optional<Double> getGamesCompleted() {
        return gamesCompleted;
    }

    @JsonProperty("concepts")
    public Optional<Map<String, Double>> getConcepts() {
        return concepts;
    }

    /**
     * @return Included only when specifically requested on the endpoint
     */
    @JsonProperty("playTime")
    public Optional<Double> getPlayTime() {
        return playTime;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UserResponseStats && equalTo((UserResponseStats) other);
    }

    private boolean equalTo(UserResponseStats other) {
        return gamesCompleted.equals(other.gamesCompleted)
                && concepts.equals(other.concepts)
                && playTime.equals(other.playTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gamesCompleted, this.concepts, this.playTime);
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

        private Optional<Map<String, Double>> concepts = Optional.empty();

        private Optional<Double> playTime = Optional.empty();

        private Builder() {}

        public Builder from(UserResponseStats other) {
            gamesCompleted(other.getGamesCompleted());
            concepts(other.getConcepts());
            playTime(other.getPlayTime());
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

        @JsonSetter(value = "concepts", nulls = Nulls.SKIP)
        public Builder concepts(Optional<Map<String, Double>> concepts) {
            this.concepts = concepts;
            return this;
        }

        public Builder concepts(Map<String, Double> concepts) {
            this.concepts = Optional.of(concepts);
            return this;
        }

        @JsonSetter(value = "playTime", nulls = Nulls.SKIP)
        public Builder playTime(Optional<Double> playTime) {
            this.playTime = playTime;
            return this;
        }

        public Builder playTime(Double playTime) {
            this.playTime = Optional.of(playTime);
            return this;
        }

        public UserResponseStats build() {
            return new UserResponseStats(gamesCompleted, concepts, playTime);
        }
    }
}
