package com.codecombat.api.resources.users.requests;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersShortenLicenseRequest.Builder.class)
public final class UsersShortenLicenseRequest {
    private final String ends;

    private UsersShortenLicenseRequest(String ends) {
        this.ends = ends;
    }

    @JsonProperty("ends")
    public String getEnds() {
        return ends;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersShortenLicenseRequest && equalTo((UsersShortenLicenseRequest) other);
    }

    private boolean equalTo(UsersShortenLicenseRequest other) {
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

        Builder from(UsersShortenLicenseRequest other);
    }

    public interface _FinalStage {
        UsersShortenLicenseRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EndsStage, _FinalStage {
        private String ends;

        private Builder() {}

        @Override
        public Builder from(UsersShortenLicenseRequest other) {
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
        public UsersShortenLicenseRequest build() {
            return new UsersShortenLicenseRequest(ends);
        }
    }
}
