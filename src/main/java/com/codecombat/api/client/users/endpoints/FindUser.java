package com.codecombat.api.client.users.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class FindUser {
  private FindUser() {
  }

  public static final class Request {
    private final String property;

    private final String value;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String property, String value, Optional<BasicAuth> authOverride) {
      this.property = property;
      this.value = value;
      this.authOverride = authOverride;
    }

    /**
     * @return The property to lookup by. May either be <code>&quot;israel-id&quot;</code> or <code>&quot;name&quot;</code>.
     */
    public String getProperty() {
      return property;
    }

    /**
     * @return The value to be looked up.
     */
    public String getValue() {
      return value;
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
      return property.equals(other.property) && value.equals(other.value) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.property, this.value, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "FindUser.Request{" + "property: " + property + ", value: " + value + ", authOverride: " + authOverride + "}";
    }

    public static PropertyStage builder() {
      return new Builder();
    }

    public interface PropertyStage {
      ValueStage property(String property);

      Builder from(Request other);
    }

    public interface ValueStage {
      _FinalStage value(String value);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements PropertyStage, ValueStage, _FinalStage {
      private String property;

      private String value;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        property(other.getProperty());
        value(other.getValue());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The property to lookup by. May either be <code>&quot;israel-id&quot;</code> or <code>&quot;name&quot;</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public ValueStage property(String property) {
        this.property = property;
        return this;
      }

      /**
       * <p>The value to be looked up.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage value(String value) {
        this.value = value;
        return this;
      }

      @Override
      public _FinalStage authOverride(BasicAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BasicAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(property, value, authOverride);
      }
    }
  }
}
