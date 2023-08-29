package com.codecombat.api.resources.users.requests;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersGrantLicenseRequest.Builder.class)
public final class UsersGrantLicenseRequest {
    private final String ends;

    private UsersGrantLicenseRequest(String ends) {
        this.ends = ends;
    }

    @JsonProperty("ends")
    public String getEnds() {
        return ends;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersGrantLicenseRequest && equalTo((UsersGrantLicenseRequest) other);
    }

    private boolean equalTo(UsersGrantLicenseRequest other) {
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

        Builder from(UsersGrantLicenseRequest other);
    }

    public interface _FinalStage {
        UsersGrantLicenseRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EndsStage, _FinalStage {
        private String ends;

        private Builder() {}

        @Override
        public Builder from(UsersGrantLicenseRequest other) {
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
        public UsersGrantLicenseRequest build() {
            return new UsersGrantLicenseRequest(ends);
        }
    }
}
