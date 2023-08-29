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
@JsonDeserialize(builder = UserResponseOAuthIdentitiesItem.Builder.class)
public final class UserResponseOAuthIdentitiesItem {
    private final Optional<String> provider;

    private final Optional<String> id;

    private UserResponseOAuthIdentitiesItem(Optional<String> provider, Optional<String> id) {
        this.provider = provider;
        this.id = id;
    }

    @JsonProperty("provider")
    public Optional<String> getProvider() {
        return provider;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UserResponseOAuthIdentitiesItem && equalTo((UserResponseOAuthIdentitiesItem) other);
    }

    private boolean equalTo(UserResponseOAuthIdentitiesItem other) {
        return provider.equals(other.provider) && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.provider, this.id);
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
        private Optional<String> provider = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Builder() {}

        public Builder from(UserResponseOAuthIdentitiesItem other) {
            provider(other.getProvider());
            id(other.getId());
            return this;
        }

        @JsonSetter(value = "provider", nulls = Nulls.SKIP)
        public Builder provider(Optional<String> provider) {
            this.provider = provider;
            return this;
        }

        public Builder provider(String provider) {
            this.provider = Optional.of(provider);
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        public UserResponseOAuthIdentitiesItem build() {
            return new UserResponseOAuthIdentitiesItem(provider, id);
        }
    }
}
