package com.codecombat.api.client.users.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetClassrooms {
  private GetClassrooms() {
  }

  public static final class Request {
    private final String handle;

    private final Optional<Double> retMemberLimit;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String handle, Optional<Double> retMemberLimit, Optional<BasicAuth> authOverride) {
      this.handle = handle;
      this.retMemberLimit = retMemberLimit;
      this.authOverride = authOverride;
    }

    /**
     * @return The document's <code>_id</code> or <code>slug</code>.
     */
    public String getHandle() {
      return handle;
    }

    /**
     * @return limit the return number of members for each classroom
     */
    public Optional<Double> getRetMemberLimit() {
      return retMemberLimit;
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
      return handle.equals(other.handle) && retMemberLimit.equals(other.retMemberLimit) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.handle, this.retMemberLimit, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetClassrooms.Request{" + "handle: " + handle + ", retMemberLimit: " + retMemberLimit + ", authOverride: " + authOverride + "}";
    }

    public static HandleStage builder() {
      return new Builder();
    }

    public interface HandleStage {
      _FinalStage handle(String handle);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

      _FinalStage retMemberLimit(Double retMemberLimit);

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements HandleStage, _FinalStage {
      private String handle;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<Double> retMemberLimit = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        handle(other.getHandle());
        retMemberLimit(other.getRetMemberLimit());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The document's <code>_id</code> or <code>slug</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage handle(String handle) {
        this.handle = handle;
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

      /**
       * <p>limit the return number of members for each classroom</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage retMemberLimit(Double retMemberLimit) {
        this.retMemberLimit = Optional.of(retMemberLimit);
        return this;
      }

      @Override
      public _FinalStage retMemberLimit(Optional<Double> retMemberLimit) {
        this.retMemberLimit = retMemberLimit;
        return this;
      }

      @Override
      public Request build() {
        return new Request(handle, retMemberLimit, authOverride);
      }
    }
  }
}
