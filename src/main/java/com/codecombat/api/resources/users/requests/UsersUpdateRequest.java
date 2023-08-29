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
@JsonDeserialize(builder = UsersUpdateRequest.Builder.class)
public final class UsersUpdateRequest {
    private final String name;

    private final Optional<String> birthday;

    private UsersUpdateRequest(String name, Optional<String> birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * @return Set to new name string
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return Set the birthday
     */
    @JsonProperty("birthday")
    public Optional<String> getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersUpdateRequest && equalTo((UsersUpdateRequest) other);
    }

    private boolean equalTo(UsersUpdateRequest other) {
        return name.equals(other.name) && birthday.equals(other.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.birthday);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(UsersUpdateRequest other);
    }

    public interface _FinalStage {
        UsersUpdateRequest build();

        _FinalStage birthday(Optional<String> birthday);

        _FinalStage birthday(String birthday);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<String> birthday = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UsersUpdateRequest other) {
            name(other.getName());
            birthday(other.getBirthday());
            return this;
        }

        /**
         * <p>Set to new name string</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>Set the birthday</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage birthday(String birthday) {
            this.birthday = Optional.of(birthday);
            return this;
        }

        @Override
        @JsonSetter(value = "birthday", nulls = Nulls.SKIP)
        public _FinalStage birthday(Optional<String> birthday) {
            this.birthday = birthday;
            return this;
        }

        @Override
        public UsersUpdateRequest build() {
            return new UsersUpdateRequest(name, birthday);
        }
    }
}
