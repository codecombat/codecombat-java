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
@JsonDeserialize(builder = LevelSessionResponseState.Builder.class)
public final class LevelSessionResponseState {
    private final Optional<Boolean> complete;

    private LevelSessionResponseState(Optional<Boolean> complete) {
        this.complete = complete;
    }

    @JsonProperty("complete")
    public Optional<Boolean> getComplete() {
        return complete;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LevelSessionResponseState && equalTo((LevelSessionResponseState) other);
    }

    private boolean equalTo(LevelSessionResponseState other) {
        return complete.equals(other.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.complete);
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
        private Optional<Boolean> complete = Optional.empty();

        private Builder() {}

        public Builder from(LevelSessionResponseState other) {
            complete(other.getComplete());
            return this;
        }

        @JsonSetter(value = "complete", nulls = Nulls.SKIP)
        public Builder complete(Optional<Boolean> complete) {
            this.complete = complete;
            return this;
        }

        public Builder complete(Boolean complete) {
            this.complete = Optional.of(complete);
            return this;
        }

        public LevelSessionResponseState build() {
            return new LevelSessionResponseState(complete);
        }
    }
}
