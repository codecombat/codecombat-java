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
@JsonDeserialize(builder = LevelSessionResponseLevel.Builder.class)
public final class LevelSessionResponseLevel {
    private final Optional<String> original;

    private LevelSessionResponseLevel(Optional<String> original) {
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
        return other instanceof LevelSessionResponseLevel && equalTo((LevelSessionResponseLevel) other);
    }

    private boolean equalTo(LevelSessionResponseLevel other) {
        return original.equals(other.original);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.original);
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
        private Optional<String> original = Optional.empty();

        private Builder() {}

        public Builder from(LevelSessionResponseLevel other) {
            original(other.getOriginal());
            return this;
        }

        @JsonSetter(value = "original", nulls = Nulls.SKIP)
        public Builder original(Optional<String> original) {
            this.original = original;
            return this;
        }

        public Builder original(String original) {
            this.original = Optional.of(original);
            return this;
        }

        public LevelSessionResponseLevel build() {
            return new LevelSessionResponseLevel(original);
        }
    }
}
