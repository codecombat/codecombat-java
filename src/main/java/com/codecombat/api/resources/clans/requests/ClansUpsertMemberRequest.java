package com.codecombat.api.resources.clans.requests;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClansUpsertMemberRequest.Builder.class)
public final class ClansUpsertMemberRequest {
    private final String userId;

    private ClansUpsertMemberRequest(String userId) {
        this.userId = userId;
    }

    /**
     * @return The <code>_id</code> or <code>slug</code> of the user to add to the clan.
     */
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClansUpsertMemberRequest && equalTo((ClansUpsertMemberRequest) other);
    }

    private boolean equalTo(ClansUpsertMemberRequest other) {
        return userId.equals(other.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UserIdStage builder() {
        return new Builder();
    }

    public interface UserIdStage {
        _FinalStage userId(String userId);

        Builder from(ClansUpsertMemberRequest other);
    }

    public interface _FinalStage {
        ClansUpsertMemberRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UserIdStage, _FinalStage {
        private String userId;

        private Builder() {}

        @Override
        public Builder from(ClansUpsertMemberRequest other) {
            userId(other.getUserId());
            return this;
        }

        /**
         * <p>The <code>_id</code> or <code>slug</code> of the user to add to the clan.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("userId")
        public _FinalStage userId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public ClansUpsertMemberRequest build() {
            return new ClansUpsertMemberRequest(userId);
        }
    }
}
