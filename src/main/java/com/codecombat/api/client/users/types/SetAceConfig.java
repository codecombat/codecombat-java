package com.codecombat.api.client.users.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = SetAceConfig.Builder.class
)
public final class SetAceConfig {
  private final Optional<Boolean> liveCompletion;

  private final Optional<Boolean> behaviors;

  private final Optional<String> language;

  private int _cachedHashCode;

  SetAceConfig(Optional<Boolean> liveCompletion, Optional<Boolean> behaviors,
      Optional<String> language) {
    this.liveCompletion = liveCompletion;
    this.behaviors = behaviors;
    this.language = language;
  }

  /**
   * @return controls whether autocompletion snippets show up, the default value is true
   */
  @JsonProperty("liveCompletion")
  public Optional<Boolean> getLiveCompletion() {
    return liveCompletion;
  }

  /**
   * @return controls whether things like automatic parenthesis and quote completion happens, the default value is false
   */
  @JsonProperty("behaviors")
  public Optional<Boolean> getBehaviors() {
    return behaviors;
  }

  /**
   * @return only for home users, should be one of [&quot;python&quot;, &quot;javascript&quot;, &quot;cpp&quot;, &quot;lua&quot;, &quot;coffeescript&quot;] right now
   */
  @JsonProperty("language")
  public Optional<String> getLanguage() {
    return language;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SetAceConfig && equalTo((SetAceConfig) other);
  }

  private boolean equalTo(SetAceConfig other) {
    return liveCompletion.equals(other.liveCompletion) && behaviors.equals(other.behaviors) && language.equals(other.language);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.liveCompletion, this.behaviors, this.language);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SetAceConfig{" + "liveCompletion: " + liveCompletion + ", behaviors: " + behaviors + ", language: " + language + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Boolean> liveCompletion = Optional.empty();

    private Optional<Boolean> behaviors = Optional.empty();

    private Optional<String> language = Optional.empty();

    private Builder() {
    }

    public Builder from(SetAceConfig other) {
      liveCompletion(other.getLiveCompletion());
      behaviors(other.getBehaviors());
      language(other.getLanguage());
      return this;
    }

    @JsonSetter(
        value = "liveCompletion",
        nulls = Nulls.SKIP
    )
    public Builder liveCompletion(Optional<Boolean> liveCompletion) {
      this.liveCompletion = liveCompletion;
      return this;
    }

    public Builder liveCompletion(Boolean liveCompletion) {
      this.liveCompletion = Optional.of(liveCompletion);
      return this;
    }

    @JsonSetter(
        value = "behaviors",
        nulls = Nulls.SKIP
    )
    public Builder behaviors(Optional<Boolean> behaviors) {
      this.behaviors = behaviors;
      return this;
    }

    public Builder behaviors(Boolean behaviors) {
      this.behaviors = Optional.of(behaviors);
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

    public SetAceConfig build() {
      return new SetAceConfig(liveCompletion, behaviors, language);
    }
  }
}
