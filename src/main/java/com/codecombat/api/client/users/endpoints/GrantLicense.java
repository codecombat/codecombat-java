package com.codecombat.api.client.users.endpoints;

import com.codecombat.api.client.users.types.GrantLicenseRequest;
import com.codecombat.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GrantLicense {
  private GrantLicense() {
  }

  public static final class Request {
    private final String handle;

    private final GrantLicenseRequest body;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String handle, GrantLicenseRequest body, Optional<BasicAuth> authOverride) {
      this.handle = handle;
      this.body = body;
      this.authOverride = authOverride;
    }

    /**
     * @return The document's <code>_id</code> or <code>slug</code>.
     */
    public String getHandle() {
      return handle;
    }

    public GrantLicenseRequest getBody() {
      return body;
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
      return handle.equals(other.handle) && body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.handle, this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GrantLicense.Request{" + "handle: " + handle + ", body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static HandleStage builder() {
      return new Builder();
    }

    public interface HandleStage {
      BodyStage handle(String handle);

      Builder from(Request other);
    }

    public interface BodyStage {
      _FinalStage body(GrantLicenseRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements HandleStage, BodyStage, _FinalStage {
      private String handle;

      private GrantLicenseRequest body;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        handle(other.getHandle());
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The document's <code>_id</code> or <code>slug</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public BodyStage handle(String handle) {
        this.handle = handle;
        return this;
      }

      @Override
      public _FinalStage body(GrantLicenseRequest body) {
        this.body = body;
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
        return new Request(handle, body, authOverride);
      }
    }
  }
}
