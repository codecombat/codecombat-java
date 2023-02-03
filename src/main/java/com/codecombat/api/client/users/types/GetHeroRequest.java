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
    builder = GetHeroRequest.Builder.class
)
public final class GetHeroRequest {
  private final Optional<String> thangType;

  private int _cachedHashCode;

  GetHeroRequest(Optional<String> thangType) {
    this.thangType = thangType;
  }

  @JsonProperty("thangType")
  public Optional<String> getThangType() {
    return thangType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetHeroRequest && equalTo((GetHeroRequest) other);
  }

  private boolean equalTo(GetHeroRequest other) {
    return thangType.equals(other.thangType);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.thangType);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetHeroRequest{" + "thangType: " + thangType + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> thangType = Optional.empty();

    private Builder() {
    }

    public Builder from(GetHeroRequest other) {
      thangType(other.getThangType());
      return this;
    }

    @JsonSetter(
        value = "thangType",
        nulls = Nulls.SKIP
    )
    public Builder thangType(Optional<String> thangType) {
      this.thangType = thangType;
      return this;
    }

    public Builder thangType(String thangType) {
      this.thangType = Optional.of(thangType);
      return this;
    }

    public GetHeroRequest build() {
      return new GetHeroRequest(thangType);
    }
  }
}
