package com.codecombat.api.resources.classrooms.requests;

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
@JsonDeserialize(builder = ClassroomsEnrollUserInCourseRequest.Builder.class)
public final class ClassroomsEnrollUserInCourseRequest {
    private final Optional<Double> retMemberLimit;

    private final String userId;

    private ClassroomsEnrollUserInCourseRequest(Optional<Double> retMemberLimit, String userId) {
        this.retMemberLimit = retMemberLimit;
        this.userId = userId;
    }

    /**
     * @return limit the return number of members for the classroom, the default value is 1000
     */
    @JsonProperty("retMemberLimit")
    public Optional<Double> getRetMemberLimit() {
        return retMemberLimit;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsEnrollUserInCourseRequest
                && equalTo((ClassroomsEnrollUserInCourseRequest) other);
    }

    private boolean equalTo(ClassroomsEnrollUserInCourseRequest other) {
        return retMemberLimit.equals(other.retMemberLimit) && userId.equals(other.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.retMemberLimit, this.userId);
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

        Builder from(ClassroomsEnrollUserInCourseRequest other);
    }

    public interface _FinalStage {
        ClassroomsEnrollUserInCourseRequest build();

        _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

        _FinalStage retMemberLimit(Double retMemberLimit);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UserIdStage, _FinalStage {
        private String userId;

        private Optional<Double> retMemberLimit = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ClassroomsEnrollUserInCourseRequest other) {
            retMemberLimit(other.getRetMemberLimit());
            userId(other.getUserId());
            return this;
        }

        @Override
        @JsonSetter("userId")
        public _FinalStage userId(String userId) {
            this.userId = userId;
            return this;
        }

        /**
         * <p>limit the return number of members for the classroom, the default value is 1000</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage retMemberLimit(Double retMemberLimit) {
            this.retMemberLimit = Optional.of(retMemberLimit);
            return this;
        }

        @Override
        @JsonSetter(value = "retMemberLimit", nulls = Nulls.SKIP)
        public _FinalStage retMemberLimit(Optional<Double> retMemberLimit) {
            this.retMemberLimit = retMemberLimit;
            return this;
        }

        @Override
        public ClassroomsEnrollUserInCourseRequest build() {
            return new ClassroomsEnrollUserInCourseRequest(retMemberLimit, userId);
        }
    }
}
