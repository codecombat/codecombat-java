package com.codecombat.api.client.users.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GrantLicenseRequest.Builder.class
)
public final class GrantLicenseRequest {
  private final String ends;

  private int _cachedHashCode;

  GrantLicenseRequest(String ends) {
    this.ends = ends;
  }

  @JsonProperty("ends")
  public String getEnds() {
    return ends;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GrantLicenseRequest && equalTo((GrantLicenseRequest) other);
  }

  private boolean equalTo(GrantLicenseRequest other) {
    return ends.equals(other.ends);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ends);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GrantLicenseRequest{" + "ends: " + ends + "}";
  }

  public static EndsStage builder() {
    return new Builder();
  }

  public interface EndsStage {
    _FinalStage ends(String ends);

    Builder from(GrantLicenseRequest other);
  }

  public interface _FinalStage {
    GrantLicenseRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EndsStage, _FinalStage {
    private String ends;

    private Builder() {
    }

    @Override
    public Builder from(GrantLicenseRequest other) {
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
    public GrantLicenseRequest build() {
      return new GrantLicenseRequest(ends);
    }
  }
}
