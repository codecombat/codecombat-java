package com.codecombat.api.client.clans.endpoints;

import com.codecombat.api.client.clans.types.UpsertClanRequest;
import com.codecombat.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class UpsertClan {
  private UpsertClan() {
  }

  public static final class Request {
    private final UpsertClanRequest body;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(UpsertClanRequest body, Optional<BasicAuth> authOverride) {
      this.body = body;
      this.authOverride = authOverride;
    }

    public UpsertClanRequest getBody() {
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
      return body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "UpsertClan.Request{" + "body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static BodyStage builder() {
      return new Builder();
    }

    public interface BodyStage {
      _FinalStage body(UpsertClanRequest body);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements BodyStage, _FinalStage {
      private UpsertClanRequest body;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public _FinalStage body(UpsertClanRequest body) {
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
        return new Request(body, authOverride);
      }
    }
  }
}
