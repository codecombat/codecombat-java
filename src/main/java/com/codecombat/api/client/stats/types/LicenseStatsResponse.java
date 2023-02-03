package com.codecombat.api.client.stats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = LicenseStatsResponse.Builder.class
)
public final class LicenseStatsResponse {
  private final Optional<Double> licenseDaysGranted;

  private final Optional<Double> licenseDaysUsed;

  private final Optional<Double> licenseDaysRemaining;

  private final Optional<Double> activeLicenses;

  private int _cachedHashCode;

  LicenseStatsResponse(Optional<Double> licenseDaysGranted, Optional<Double> licenseDaysUsed,
      Optional<Double> licenseDaysRemaining, Optional<Double> activeLicenses) {
    this.licenseDaysGranted = licenseDaysGranted;
    this.licenseDaysUsed = licenseDaysUsed;
    this.licenseDaysRemaining = licenseDaysRemaining;
    this.activeLicenses = activeLicenses;
  }

  /**
   * @return Total number of license days granted
   */
  @JsonProperty("licenseDaysGranted")
  public Optional<Double> getLicenseDaysGranted() {
    return licenseDaysGranted;
  }

  /**
   * @return Number of license days used
   */
  @JsonProperty("licenseDaysUsed")
  public Optional<Double> getLicenseDaysUsed() {
    return licenseDaysUsed;
  }

  /**
   * @return Number of license days remaining
   */
  @JsonProperty("licenseDaysRemaining")
  public Optional<Double> getLicenseDaysRemaining() {
    return licenseDaysRemaining;
  }

  /**
   * @return Number of active/valid licenses
   */
  @JsonProperty("activeLicenses")
  public Optional<Double> getActiveLicenses() {
    return activeLicenses;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LicenseStatsResponse && equalTo((LicenseStatsResponse) other);
  }

  private boolean equalTo(LicenseStatsResponse other) {
    return licenseDaysGranted.equals(other.licenseDaysGranted) && licenseDaysUsed.equals(other.licenseDaysUsed) && licenseDaysRemaining.equals(other.licenseDaysRemaining) && activeLicenses.equals(other.activeLicenses);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.licenseDaysGranted, this.licenseDaysUsed, this.licenseDaysRemaining, this.activeLicenses);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LicenseStatsResponse{" + "licenseDaysGranted: " + licenseDaysGranted + ", licenseDaysUsed: " + licenseDaysUsed + ", licenseDaysRemaining: " + licenseDaysRemaining + ", activeLicenses: " + activeLicenses + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Double> licenseDaysGranted = Optional.empty();

    private Optional<Double> licenseDaysUsed = Optional.empty();

    private Optional<Double> licenseDaysRemaining = Optional.empty();

    private Optional<Double> activeLicenses = Optional.empty();

    private Builder() {
    }

    public Builder from(LicenseStatsResponse other) {
      licenseDaysGranted(other.getLicenseDaysGranted());
      licenseDaysUsed(other.getLicenseDaysUsed());
      licenseDaysRemaining(other.getLicenseDaysRemaining());
      activeLicenses(other.getActiveLicenses());
      return this;
    }

    @JsonSetter(
        value = "licenseDaysGranted",
        nulls = Nulls.SKIP
    )
    public Builder licenseDaysGranted(Optional<Double> licenseDaysGranted) {
      this.licenseDaysGranted = licenseDaysGranted;
      return this;
    }

    public Builder licenseDaysGranted(Double licenseDaysGranted) {
      this.licenseDaysGranted = Optional.of(licenseDaysGranted);
      return this;
    }

    @JsonSetter(
        value = "licenseDaysUsed",
        nulls = Nulls.SKIP
    )
    public Builder licenseDaysUsed(Optional<Double> licenseDaysUsed) {
      this.licenseDaysUsed = licenseDaysUsed;
      return this;
    }

    public Builder licenseDaysUsed(Double licenseDaysUsed) {
      this.licenseDaysUsed = Optional.of(licenseDaysUsed);
      return this;
    }

    @JsonSetter(
        value = "licenseDaysRemaining",
        nulls = Nulls.SKIP
    )
    public Builder licenseDaysRemaining(Optional<Double> licenseDaysRemaining) {
      this.licenseDaysRemaining = licenseDaysRemaining;
      return this;
    }

    public Builder licenseDaysRemaining(Double licenseDaysRemaining) {
      this.licenseDaysRemaining = Optional.of(licenseDaysRemaining);
      return this;
    }

    @JsonSetter(
        value = "activeLicenses",
        nulls = Nulls.SKIP
    )
    public Builder activeLicenses(Optional<Double> activeLicenses) {
      this.activeLicenses = activeLicenses;
      return this;
    }

    public Builder activeLicenses(Double activeLicenses) {
      this.activeLicenses = Optional.of(activeLicenses);
      return this;
    }

    public LicenseStatsResponse build() {
      return new LicenseStatsResponse(licenseDaysGranted, licenseDaysUsed, licenseDaysRemaining, activeLicenses);
    }
  }
}
