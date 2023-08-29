package com.codecombat.api.resources.users.requests;

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
@JsonDeserialize(builder = UsersGetRequest.Builder.class)
public final class UsersGetRequest {
    private final Optional<String> includePlayTime;

    private UsersGetRequest(Optional<String> includePlayTime) {
        this.includePlayTime = includePlayTime;
    }

    /**
     * @return Set to non-empty string to include stats.playTime in response
     */
    @JsonProperty("includePlayTime")
    public Optional<String> getIncludePlayTime() {
        return includePlayTime;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersGetRequest && equalTo((UsersGetRequest) other);
    }

    private boolean equalTo(UsersGetRequest other) {
        return includePlayTime.equals(other.includePlayTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.includePlayTime);
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
        private Optional<String> includePlayTime = Optional.empty();

        private Builder() {}

        public Builder from(UsersGetRequest other) {
            includePlayTime(other.getIncludePlayTime());
            return this;
        }

        @JsonSetter(value = "includePlayTime", nulls = Nulls.SKIP)
        public Builder includePlayTime(Optional<String> includePlayTime) {
            this.includePlayTime = includePlayTime;
            return this;
        }

        public Builder includePlayTime(String includePlayTime) {
            this.includePlayTime = Optional.of(includePlayTime);
            return this;
        }

        public UsersGetRequest build() {
            return new UsersGetRequest(includePlayTime);
        }
    }
}
