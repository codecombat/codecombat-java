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
@JsonDeserialize(builder = ClassroomsUpsertMemberRequest.Builder.class)
public final class ClassroomsUpsertMemberRequest {
    private final String code;

    private final String userId;

    private final Optional<Double> retMemberLimit;

    private ClassroomsUpsertMemberRequest(String code, String userId, Optional<Double> retMemberLimit) {
        this.code = code;
        this.userId = userId;
        this.retMemberLimit = retMemberLimit;
    }

    /**
     * @return The code for joining this classroom
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * @return The <code>_id</code> or <code>slug</code> of the user to add to the class.
     */
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    /**
     * @return limit the return number of members for the classroom, the default value is 1000
     */
    @JsonProperty("retMemberLimit")
    public Optional<Double> getRetMemberLimit() {
        return retMemberLimit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsUpsertMemberRequest && equalTo((ClassroomsUpsertMemberRequest) other);
    }

    private boolean equalTo(ClassroomsUpsertMemberRequest other) {
        return code.equals(other.code) && userId.equals(other.userId) && retMemberLimit.equals(other.retMemberLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.userId, this.retMemberLimit);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CodeStage builder() {
        return new Builder();
    }

    public interface CodeStage {
        UserIdStage code(String code);

        Builder from(ClassroomsUpsertMemberRequest other);
    }

    public interface UserIdStage {
        _FinalStage userId(String userId);
    }

    public interface _FinalStage {
        ClassroomsUpsertMemberRequest build();

        _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

        _FinalStage retMemberLimit(Double retMemberLimit);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CodeStage, UserIdStage, _FinalStage {
        private String code;

        private String userId;

        private Optional<Double> retMemberLimit = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ClassroomsUpsertMemberRequest other) {
            code(other.getCode());
            userId(other.getUserId());
            retMemberLimit(other.getRetMemberLimit());
            return this;
        }

        /**
         * <p>The code for joining this classroom</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("code")
        public UserIdStage code(String code) {
            this.code = code;
            return this;
        }

        /**
         * <p>The <code>_id</code> or <code>slug</code> of the user to add to the class.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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
        public ClassroomsUpsertMemberRequest build() {
            return new ClassroomsUpsertMemberRequest(code, userId, retMemberLimit);
        }
    }
}
