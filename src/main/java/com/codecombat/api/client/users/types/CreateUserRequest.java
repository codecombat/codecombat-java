package com.codecombat.api.client.users.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = CreateUserRequest.Builder.class
)
public final class CreateUserRequest {
  private final String name;

  private final String email;

  private final Optional<UserRole> role;

  private final Optional<String> preferredLanguage;

  private final Optional<HeroConfig> heroConfig;

  private final Optional<String> birthday;

  private int _cachedHashCode;

  CreateUserRequest(String name, String email, Optional<UserRole> role,
      Optional<String> preferredLanguage, Optional<HeroConfig> heroConfig,
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
   * @return A <code>&quot;student&quot;</code> or <code>&quot;teacher&quot;</code>. If unset, a home user will be created, unable to join classrooms.
   */
  @JsonProperty("role")
  public Optional<UserRole> getRole() {
    return role;
  }

  @JsonProperty("preferredLanguage")
  public Optional<String> getPreferredLanguage() {
    return preferredLanguage;
  }

  @JsonProperty("heroConfig")
  public Optional<HeroConfig> getHeroConfig() {
    return heroConfig;
  }

  @JsonProperty("birthday")
  public Optional<String> getBirthday() {
    return birthday;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateUserRequest && equalTo((CreateUserRequest) other);
  }

  private boolean equalTo(CreateUserRequest other) {
    return name.equals(other.name) && email.equals(other.email) && role.equals(other.role) && preferredLanguage.equals(other.preferredLanguage) && heroConfig.equals(other.heroConfig) && birthday.equals(other.birthday);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.email, this.role, this.preferredLanguage, this.heroConfig, this.birthday);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateUserRequest{" + "name: " + name + ", email: " + email + ", role: " + role + ", preferredLanguage: " + preferredLanguage + ", heroConfig: " + heroConfig + ", birthday: " + birthday + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    EmailStage name(String name);

    Builder from(CreateUserRequest other);
  }

  public interface EmailStage {
    _FinalStage email(String email);
  }

  public interface _FinalStage {
    CreateUserRequest build();

    _FinalStage role(Optional<UserRole> role);

    _FinalStage role(UserRole role);

    _FinalStage preferredLanguage(Optional<String> preferredLanguage);

    _FinalStage preferredLanguage(String preferredLanguage);

    _FinalStage heroConfig(Optional<HeroConfig> heroConfig);

    _FinalStage heroConfig(HeroConfig heroConfig);

    _FinalStage birthday(Optional<String> birthday);

    _FinalStage birthday(String birthday);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, EmailStage, _FinalStage {
    private String name;

    private String email;

    private Optional<String> birthday = Optional.empty();

    private Optional<HeroConfig> heroConfig = Optional.empty();

    private Optional<String> preferredLanguage = Optional.empty();

    private Optional<UserRole> role = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(CreateUserRequest other) {
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
    @JsonSetter(
        value = "birthday",
        nulls = Nulls.SKIP
    )
    public _FinalStage birthday(Optional<String> birthday) {
      this.birthday = birthday;
      return this;
    }

    @Override
    public _FinalStage heroConfig(HeroConfig heroConfig) {
      this.heroConfig = Optional.of(heroConfig);
      return this;
    }

    @Override
    @JsonSetter(
        value = "heroConfig",
        nulls = Nulls.SKIP
    )
    public _FinalStage heroConfig(Optional<HeroConfig> heroConfig) {
      this.heroConfig = heroConfig;
      return this;
    }

    @Override
    public _FinalStage preferredLanguage(String preferredLanguage) {
      this.preferredLanguage = Optional.of(preferredLanguage);
      return this;
    }

    @Override
    @JsonSetter(
        value = "preferredLanguage",
        nulls = Nulls.SKIP
    )
    public _FinalStage preferredLanguage(Optional<String> preferredLanguage) {
      this.preferredLanguage = preferredLanguage;
      return this;
    }

    /**
     * <p>A <code>&quot;student&quot;</code> or <code>&quot;teacher&quot;</code>. If unset, a home user will be created, unable to join classrooms.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage role(UserRole role) {
      this.role = Optional.of(role);
      return this;
    }

    @Override
    @JsonSetter(
        value = "role",
        nulls = Nulls.SKIP
    )
    public _FinalStage role(Optional<UserRole> role) {
      this.role = role;
      return this;
    }

    @Override
    public CreateUserRequest build() {
      return new CreateUserRequest(name, email, role, preferredLanguage, heroConfig, birthday);
    }
  }
}
