package com.codecombat.api.client.users.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Get {
  private Get() {
  }

  public static final class Request {
    private final String handle;

    private final Optional<String> includePlayTime;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String handle, Optional<String> includePlayTime, Optional<BasicAuth> authOverride) {
      this.handle = handle;
      this.includePlayTime = includePlayTime;
      this.authOverride = authOverride;
    }

    /**
     * @return The document's <code>_id</code> or <code>slug</code>.
     */
    public String getHandle() {
      return handle;
    }

    /**
     * @return Set to non-empty string to include stats.playTime in response
     */
    public Optional<String> getIncludePlayTime() {
      return includePlayTime;
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
      return handle.equals(other.handle) && includePlayTime.equals(other.includePlayTime) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.handle, this.includePlayTime, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Get.Request{" + "handle: " + handle + ", includePlayTime: " + includePlayTime + ", authOverride: " + authOverride + "}";
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

      _FinalStage includePlayTime(Optional<String> includePlayTime);

      _FinalStage includePlayTime(String includePlayTime);

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements HandleStage, _FinalStage {
      private String handle;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<String> includePlayTime = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        handle(other.getHandle());
        includePlayTime(other.getIncludePlayTime());
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
       * <p>Set to non-empty string to include stats.playTime in response</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage includePlayTime(String includePlayTime) {
        this.includePlayTime = Optional.of(includePlayTime);
        return this;
      }

      @Override
      public _FinalStage includePlayTime(Optional<String> includePlayTime) {
        this.includePlayTime = includePlayTime;
        return this;
      }

      @Override
      public Request build() {
        return new Request(handle, includePlayTime, authOverride);
      }
    }
  }
}
