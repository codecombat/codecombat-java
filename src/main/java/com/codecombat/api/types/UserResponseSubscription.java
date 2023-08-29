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
@JsonDeserialize(builder = UserResponseSubscription.Builder.class)
public final class UserResponseSubscription {
    private final Optional<String> ends;

    private final Optional<Boolean> active;

    private UserResponseSubscription(Optional<String> ends, Optional<Boolean> active) {
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
        return other instanceof UserResponseSubscription && equalTo((UserResponseSubscription) other);
    }

    private boolean equalTo(UserResponseSubscription other) {
        return ends.equals(other.ends) && active.equals(other.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ends, this.active);
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
        private Optional<String> ends = Optional.empty();

        private Optional<Boolean> active = Optional.empty();

        private Builder() {}

        public Builder from(UserResponseSubscription other) {
            ends(other.getEnds());
            active(other.getActive());
            return this;
        }

        @JsonSetter(value = "ends", nulls = Nulls.SKIP)
        public Builder ends(Optional<String> ends) {
            this.ends = ends;
            return this;
        }

        public Builder ends(String ends) {
            this.ends = Optional.of(ends);
            return this;
        }

        @JsonSetter(value = "active", nulls = Nulls.SKIP)
        public Builder active(Optional<Boolean> active) {
            this.active = active;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = Optional.of(active);
            return this;
        }

        public UserResponseSubscription build() {
            return new UserResponseSubscription(ends, active);
        }
    }
}
