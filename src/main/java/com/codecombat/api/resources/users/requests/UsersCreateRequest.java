package com.codecombat.api.resources.users.requests;

import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.types.UsersCreateRequestHeroConfig;
import com.codecombat.api.types.UsersCreateRequestRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersCreateRequest.Builder.class)
public final class UsersCreateRequest {
    private final String name;

    private final String email;

    private final Optional<UsersCreateRequestRole> role;

    private final Optional<String> preferredLanguage;

    private final Optional<UsersCreateRequestHeroConfig> heroConfig;

    private final Optional<String> birthday;

    private UsersCreateRequest(
            String name,
            String email,
            Optional<UsersCreateRequestRole> role,
            Optional<String> preferredLanguage,
            Optional<UsersCreateRequestHeroConfig> heroConfig,
            Optional<String> birthday) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.preferredLanguage = preferredLanguage;
        this.heroConfig = heroConfig;
        this.birthday = birthday;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @return <code>&quot;student&quot;</code> or <code>&quot;teacher&quot;</code>. If unset, a home user will be created, unable to join classrooms.
     */
    @JsonProperty("role")
    public Optional<UsersCreateRequestRole> getRole() {
        return role;
    }

    @JsonProperty("preferredLanguage")
    public Optional<String> getPreferredLanguage() {
        return preferredLanguage;
    }

    @JsonProperty("heroConfig")
    public Optional<UsersCreateRequestHeroConfig> getHeroConfig() {
        return heroConfig;
    }

    @JsonProperty("birthday")
    public Optional<String> getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersCreateRequest && equalTo((UsersCreateRequest) other);
    }

    private boolean equalTo(UsersCreateRequest other) {
        return name.equals(other.name)
                && email.equals(other.email)
                && role.equals(other.role)
                && preferredLanguage.equals(other.preferredLanguage)
                && heroConfig.equals(other.heroConfig)
                && birthday.equals(other.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.email, this.role, this.preferredLanguage, this.heroConfig, this.birthday);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        EmailStage name(String name);

        Builder from(UsersCreateRequest other);
    }

    public interface EmailStage {
        _FinalStage email(String email);
    }

    public interface _FinalStage {
        UsersCreateRequest build();

        _FinalStage role(Optional<UsersCreateRequestRole> role);

        _FinalStage role(UsersCreateRequestRole role);

        _FinalStage preferredLanguage(Optional<String> preferredLanguage);

        _FinalStage preferredLanguage(String preferredLanguage);

        _FinalStage heroConfig(Optional<UsersCreateRequestHeroConfig> heroConfig);

        _FinalStage heroConfig(UsersCreateRequestHeroConfig heroConfig);

        _FinalStage birthday(Optional<String> birthday);

        _FinalStage birthday(String birthday);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, EmailStage, _FinalStage {
        private String name;

        private String email;

        private Optional<String> birthday = Optional.empty();

        private Optional<UsersCreateRequestHeroConfig> heroConfig = Optional.empty();

        private Optional<String> preferredLanguage = Optional.empty();

        private Optional<UsersCreateRequestRole> role = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(UsersCreateRequest other) {
            name(other.getName());
            email(other.getEmail());
            role(other.getRole());
            preferredLanguage(other.getPreferredLanguage());
            heroConfig(other.getHeroConfig());
            birthday(other.getBirthday());
            return this;
        }

        @Override
        @JsonSetter("name")
        public EmailStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("email")
        public _FinalStage email(String email) {
            this.email = email;
            return this;
        }

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
        public _FinalStage heroConfig(UsersCreateRequestHeroConfig heroConfig) {
            this.heroConfig = Optional.of(heroConfig);
            return this;
        }

        @Override
        @JsonSetter(value = "heroConfig", nulls = Nulls.SKIP)
        public _FinalStage heroConfig(Optional<UsersCreateRequestHeroConfig> heroConfig) {
            this.heroConfig = heroConfig;
            return this;
        }

        @Override
        public _FinalStage preferredLanguage(String preferredLanguage) {
            this.preferredLanguage = Optional.of(preferredLanguage);
            return this;
        }

        @Override
        @JsonSetter(value = "preferredLanguage", nulls = Nulls.SKIP)
        public _FinalStage preferredLanguage(Optional<String> preferredLanguage) {
            this.preferredLanguage = preferredLanguage;
            return this;
        }

        /**
         * <p><code>&quot;student&quot;</code> or <code>&quot;teacher&quot;</code>. If unset, a home user will be created, unable to join classrooms.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage role(UsersCreateRequestRole role) {
            this.role = Optional.of(role);
            return this;
        }

        @Override
        @JsonSetter(value = "role", nulls = Nulls.SKIP)
        public _FinalStage role(Optional<UsersCreateRequestRole> role) {
            this.role = role;
            return this;
        }

        @Override
        public UsersCreateRequest build() {
            return new UsersCreateRequest(name, email, role, preferredLanguage, heroConfig, birthday);
        }
    }
}
