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
@JsonDeserialize(builder = UsersCreateRequestHeroConfig.Builder.class)
public final class UsersCreateRequestHeroConfig {
    private final Optional<String> thangType;

    private UsersCreateRequestHeroConfig(Optional<String> thangType) {
        this.thangType = thangType;
    }

    @JsonProperty("thangType")
    public Optional<String> getThangType() {
        return thangType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersCreateRequestHeroConfig && equalTo((UsersCreateRequestHeroConfig) other);
    }

    private boolean equalTo(UsersCreateRequestHeroConfig other) {
        return thangType.equals(other.thangType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.thangType);
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
        private Optional<String> thangType = Optional.empty();

        private Builder() {}

        public Builder from(UsersCreateRequestHeroConfig other) {
            thangType(other.getThangType());
            return this;
        }

        @JsonSetter(value = "thangType", nulls = Nulls.SKIP)
        public Builder thangType(Optional<String> thangType) {
            this.thangType = thangType;
            return this;
        }

        public Builder thangType(String thangType) {
            this.thangType = Optional.of(thangType);
            return this;
        }

        public UsersCreateRequestHeroConfig build() {
            return new UsersCreateRequestHeroConfig(thangType);
        }
    }
}
