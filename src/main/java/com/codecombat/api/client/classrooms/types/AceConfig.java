package com.codecombat.api.client.classrooms.types;

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
    builder = AceConfig.Builder.class
)
public final class AceConfig {
  private final Optional<String> language;

  private int _cachedHashCode;

  AceConfig(Optional<String> language) {
    this.language = language;
  }

  /**
   * @return Programming language for the classroom
   */
  @JsonProperty("language")
  public Optional<String> getLanguage() {
    return language;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AceConfig && equalTo((AceConfig) other);
  }

  private boolean equalTo(AceConfig other) {
    return language.equals(other.language);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.language);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AceConfig{" + "language: " + language + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> language = Optional.empty();

    private Builder() {
    }

    public Builder from(AceConfig other) {
      language(other.getLanguage());
      return this;
    }

    @JsonSetter(
        value = "language",
        nulls = Nulls.SKIP
    )
    public Builder language(Optional<String> language) {
      this.language = language;
      return this;
    }

    public Builder language(String language) {
      this.language = Optional.of(language);
      return this;
    }

    public AceConfig build() {
      return new AceConfig(language);
    }
  }
}
