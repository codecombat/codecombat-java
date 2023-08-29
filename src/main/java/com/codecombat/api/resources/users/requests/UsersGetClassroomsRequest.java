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
@JsonDeserialize(builder = UsersGetClassroomsRequest.Builder.class)
public final class UsersGetClassroomsRequest {
    private final Optional<Double> retMemberLimit;

    private UsersGetClassroomsRequest(Optional<Double> retMemberLimit) {
        this.retMemberLimit = retMemberLimit;
    }

    /**
     * @return limit the return number of members for each classroom
     */
    @JsonProperty("retMemberLimit")
    public Optional<Double> getRetMemberLimit() {
        return retMemberLimit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersGetClassroomsRequest && equalTo((UsersGetClassroomsRequest) other);
    }

    private boolean equalTo(UsersGetClassroomsRequest other) {
        return retMemberLimit.equals(other.retMemberLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.retMemberLimit);
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
        private Optional<Double> retMemberLimit = Optional.empty();

        private Builder() {}

        public Builder from(UsersGetClassroomsRequest other) {
            retMemberLimit(other.getRetMemberLimit());
            return this;
        }

        @JsonSetter(value = "retMemberLimit", nulls = Nulls.SKIP)
        public Builder retMemberLimit(Optional<Double> retMemberLimit) {
            this.retMemberLimit = retMemberLimit;
            return this;
        }

        public Builder retMemberLimit(Double retMemberLimit) {
            this.retMemberLimit = Optional.of(retMemberLimit);
            return this;
        }

        public UsersGetClassroomsRequest build() {
            return new UsersGetClassroomsRequest(retMemberLimit);
        }
    }
}
