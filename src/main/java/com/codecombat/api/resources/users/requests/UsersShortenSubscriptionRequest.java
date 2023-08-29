package com.codecombat.api.resources.users.requests;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersShortenSubscriptionRequest.Builder.class)
public final class UsersShortenSubscriptionRequest {
    private final String ends;

    private UsersShortenSubscriptionRequest(String ends) {
        this.ends = ends;
    }

    @JsonProperty("ends")
    public String getEnds() {
        return ends;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersShortenSubscriptionRequest && equalTo((UsersShortenSubscriptionRequest) other);
    }

    private boolean equalTo(UsersShortenSubscriptionRequest other) {
        return ends.equals(other.ends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ends);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EndsStage builder() {
        return new Builder();
    }

    public interface EndsStage {
        _FinalStage ends(String ends);

        Builder from(UsersShortenSubscriptionRequest other);
    }

    public interface _FinalStage {
        UsersShortenSubscriptionRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EndsStage, _FinalStage {
        private String ends;

        private Builder() {}

        @Override
        public Builder from(UsersShortenSubscriptionRequest other) {
            ends(other.getEnds());
            return this;
        }

        @Override
        @JsonSetter("ends")
        public _FinalStage ends(String ends) {
            this.ends = ends;
            return this;
        }

        @Override
        public UsersShortenSubscriptionRequest build() {
            return new UsersShortenSubscriptionRequest(ends);
        }
    }
}
