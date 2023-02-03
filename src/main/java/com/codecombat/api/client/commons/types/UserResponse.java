package com.codecombat.api.client.commons.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = UserResponse.Builder.class
)
public final class UserResponse {
  private final Optional<String> id;

  private final Optional<String> email;

  private final Optional<String> name;

  private final Optional<String> slug;

  private final Optional<String> role;

  private final Optional<UserStats> stats;

  private final Optional<List<AuthIdentity>> oAuthIdentities;

  private final Optional<Subscription> subscription;

  private final Optional<License> license;

  private int _cachedHashCode;

  UserResponse(Optional<String> id, Optional<String> email, Optional<String> name,
      Optional<String> slug, Optional<String> role, Optional<UserStats> stats,
      Optional<List<AuthIdentity>> oAuthIdentities, Optional<Subscription> subscription,
      Optional<License> license) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.slug = slug;
    this.role = role;
    this.stats = stats;
    this.oAuthIdentities = oAuthIdentities;
    this.subscription = subscription;
    this.license = license;
  }

  @JsonProperty("_id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("email")
  public Optional<String> getEmail() {
    return email;
  }

  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  @JsonProperty("slug")
  public Optional<String> getSlug() {
    return slug;
  }

  @JsonProperty("role")
  public Optional<String> getRole() {
    return role;
  }

  @JsonProperty("stats")
  public Optional<UserStats> getStats() {
    return stats;
  }

  @JsonProperty("oAuthIdentities")
  public Optional<List<AuthIdentity>> getOAuthIdentities() {
    return oAuthIdentities;
  }

  @JsonProperty("subscription")
  public Optional<Subscription> getSubscription() {
    return subscription;
  }

  @JsonProperty("license")
  public Optional<License> getLicense() {
    return license;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UserResponse && equalTo((UserResponse) other);
  }

  private boolean equalTo(UserResponse other) {
    return id.equals(other.id) && email.equals(other.email) && name.equals(other.name) && slug.equals(other.slug) && role.equals(other.role) && stats.equals(other.stats) && oAuthIdentities.equals(other.oAuthIdentities) && subscription.equals(other.subscription) && license.equals(other.license);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.email, this.name, this.slug, this.role, this.stats, this.oAuthIdentities, this.subscription, this.license);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UserResponse{" + "id: " + id + ", email: " + email + ", name: " + name + ", slug: " + slug + ", role: " + role + ", stats: " + stats + ", oAuthIdentities: " + oAuthIdentities + ", subscription: " + subscription + ", license: " + license + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> id = Optional.empty();

    private Optional<String> email = Optional.empty();

    private Optional<String> name = Optional.empty();

    private Optional<String> slug = Optional.empty();

    private Optional<String> role = Optional.empty();

    private Optional<UserStats> stats = Optional.empty();

    private Optional<List<AuthIdentity>> oAuthIdentities = Optional.empty();

    private Optional<Subscription> subscription = Optional.empty();

    private Optional<License> license = Optional.empty();

    private Builder() {
    }

    public Builder from(UserResponse other) {
      id(other.getId());
      email(other.getEmail());
      name(other.getName());
      slug(other.getSlug());
      role(other.getRole());
      stats(other.getStats());
      oAuthIdentities(other.getOAuthIdentities());
      subscription(other.getSubscription());
      license(other.getLicense());
      return this;
    }

    @JsonSetter(
        value = "_id",
        nulls = Nulls.SKIP
    )
    public Builder id(Optional<String> id) {
      this.id = id;
      return this;
    }

    public Builder id(String id) {
      this.id = Optional.of(id);
      return this;
    }

    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public Builder email(Optional<String> email) {
      this.email = email;
      return this;
    }

    public Builder email(String email) {
      this.email = Optional.of(email);
      return this;
    }

    @JsonSetter(
        value = "name",
        nulls = Nulls.SKIP
    )
    public Builder name(Optional<String> name) {
      this.name = name;
      return this;
    }

    public Builder name(String name) {
      this.name = Optional.of(name);
      return this;
    }

    @JsonSetter(
        value = "slug",
        nulls = Nulls.SKIP
    )
    public Builder slug(Optional<String> slug) {
      this.slug = slug;
      return this;
    }

    public Builder slug(String slug) {
      this.slug = Optional.of(slug);
      return this;
    }

    @JsonSetter(
        value = "role",
        nulls = Nulls.SKIP
    )
    public Builder role(Optional<String> role) {
      this.role = role;
      return this;
    }

    public Builder role(String role) {
      this.role = Optional.of(role);
      return this;
    }

    @JsonSetter(
        value = "stats",
        nulls = Nulls.SKIP
    )
    public Builder stats(Optional<UserStats> stats) {
      this.stats = stats;
      return this;
    }

    public Builder stats(UserStats stats) {
      this.stats = Optional.of(stats);
      return this;
    }

    @JsonSetter(
        value = "oAuthIdentities",
        nulls = Nulls.SKIP
    )
    public Builder oAuthIdentities(Optional<List<AuthIdentity>> oAuthIdentities) {
      this.oAuthIdentities = oAuthIdentities;
      return this;
    }

    public Builder oAuthIdentities(List<AuthIdentity> oAuthIdentities) {
      this.oAuthIdentities = Optional.of(oAuthIdentities);
      return this;
    }

    @JsonSetter(
        value = "subscription",
        nulls = Nulls.SKIP
    )
    public Builder subscription(Optional<Subscription> subscription) {
      this.subscription = subscription;
      return this;
    }

    public Builder subscription(Subscription subscription) {
      this.subscription = Optional.of(subscription);
      return this;
    }

    @JsonSetter(
        value = "license",
        nulls = Nulls.SKIP
    )
    public Builder license(Optional<License> license) {
      this.license = license;
      return this;
    }

    public Builder license(License license) {
      this.license = Optional.of(license);
      return this;
    }

    public UserResponse build() {
      return new UserResponse(id, email, name, slug, role, stats, oAuthIdentities, subscription, license);
    }
  }
}
