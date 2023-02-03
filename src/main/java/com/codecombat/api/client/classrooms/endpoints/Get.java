package com.codecombat.api.client.classrooms.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Get {
  private Get() {
  }

  public static final class Request {
    private final String code;

    private final Optional<Double> retMemberLimit;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String code, Optional<Double> retMemberLimit, Optional<BasicAuth> authOverride) {
      this.code = code;
      this.retMemberLimit = retMemberLimit;
      this.authOverride = authOverride;
    }

    /**
     * @return The classroom's <code>code</code>.
     */
    public String getCode() {
      return code;
    }

    /**
     * @return limit the return number of members for the classroom
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
      return code.equals(other.code) && retMemberLimit.equals(other.retMemberLimit) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.code, this.retMemberLimit, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Get.Request{" + "code: " + code + ", retMemberLimit: " + retMemberLimit + ", authOverride: " + authOverride + "}";
    }

    public static CodeStage builder() {
      return new Builder();
    }

    public interface CodeStage {
      _FinalStage code(String code);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

      _FinalStage retMemberLimit(Double retMemberLimit);

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements CodeStage, _FinalStage {
      private String code;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<Double> retMemberLimit = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        code(other.getCode());
        retMemberLimit(other.getRetMemberLimit());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The classroom's <code>code</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage code(String code) {
        this.code = code;
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
       * <p>limit the return number of members for the classroom</p>
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
        return new Request(code, retMemberLimit, authOverride);
      }
    }
  }
}
