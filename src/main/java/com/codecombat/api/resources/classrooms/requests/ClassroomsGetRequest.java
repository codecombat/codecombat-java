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
@JsonDeserialize(builder = ClassroomsGetRequest.Builder.class)
public final class ClassroomsGetRequest {
    private final String code;

    private final Optional<Double> retMemberLimit;

    private ClassroomsGetRequest(String code, Optional<Double> retMemberLimit) {
        this.code = code;
        this.retMemberLimit = retMemberLimit;
    }

    /**
     * @return The classroom's <code>code</code>.
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * @return limit the return number of members for the classroom
     */
    @JsonProperty("retMemberLimit")
    public Optional<Double> getRetMemberLimit() {
        return retMemberLimit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsGetRequest && equalTo((ClassroomsGetRequest) other);
    }

    private boolean equalTo(ClassroomsGetRequest other) {
        return code.equals(other.code) && retMemberLimit.equals(other.retMemberLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.retMemberLimit);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CodeStage builder() {
        return new Builder();
    }

    public interface CodeStage {
        _FinalStage code(String code);

        Builder from(ClassroomsGetRequest other);
    }

    public interface _FinalStage {
        ClassroomsGetRequest build();

        _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

        _FinalStage retMemberLimit(Double retMemberLimit);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CodeStage, _FinalStage {
        private String code;

        private Optional<Double> retMemberLimit = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(ClassroomsGetRequest other) {
            code(other.getCode());
            retMemberLimit(other.getRetMemberLimit());
            return this;
        }

        /**
         * <p>The classroom's <code>code</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("code")
        public _FinalStage code(String code) {
            this.code = code;
            return this;
        }

        /**
         * <p>limit the return number of members for the classroom</p>
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
        public ClassroomsGetRequest build() {
            return new ClassroomsGetRequest(code, retMemberLimit);
        }
    }
}
