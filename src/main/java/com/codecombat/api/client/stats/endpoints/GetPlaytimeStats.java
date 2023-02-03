package com.codecombat.api.client.stats.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetPlaytimeStats {
  private GetPlaytimeStats() {
  }

  public static final class Request {
    private final Optional<String> startDate;

    private final Optional<String> endDate;

    private final Optional<String> country;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(Optional<String> startDate, Optional<String> endDate, Optional<String> country,
        Optional<BasicAuth> authOverride) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.country = country;
      this.authOverride = authOverride;
    }

    /**
     * @return Earliest an included user was created
     */
    public Optional<String> getStartDate() {
      return startDate;
    }

    /**
     * @return Latest an included user was created
     */
    public Optional<String> getEndDate() {
      return endDate;
    }

    /**
     * @return Filter by country string
     */
    public Optional<String> getCountry() {
      return country;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return startDate.equals(other.startDate) && endDate.equals(other.endDate) && country.equals(other.country) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.startDate, this.endDate, this.country, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetPlaytimeStats.Request{" + "startDate: " + startDate + ", endDate: " + endDate + ", country: " + country + ", authOverride: " + authOverride + "}";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static final class Builder {
      private Optional<String> startDate = Optional.empty();

      private Optional<String> endDate = Optional.empty();

      private Optional<String> country = Optional.empty();

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      public Builder from(Request other) {
        startDate(other.getStartDate());
        endDate(other.getEndDate());
        country(other.getCountry());
        authOverride(other.getAuthOverride());
        return this;
      }

      public Builder startDate(Optional<String> startDate) {
        this.startDate = startDate;
        return this;
      }

      public Builder startDate(String startDate) {
        this.startDate = Optional.of(startDate);
        return this;
      }

      public Builder endDate(Optional<String> endDate) {
        this.endDate = endDate;
        return this;
      }

      public Builder endDate(String endDate) {
        this.endDate = Optional.of(endDate);
        return this;
      }

      public Builder country(Optional<String> country) {
        this.country = country;
        return this;
      }

      public Builder country(String country) {
        this.country = Optional.of(country);
        return this;
      }

      public Builder authOverride(Optional<BasicAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      public Builder authOverride(BasicAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      public Request build() {
        return new Request(startDate, endDate, country, authOverride);
      }
    }
  }
}
