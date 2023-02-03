package com.codecombat.api.client.auth.endpoints;

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
    private final String provider;

    private final Optional<String> accessToken;

    private final Optional<String> code;

    private final Optional<String> redirect;

    private final Optional<String> errorRedirect;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String provider, Optional<String> accessToken, Optional<String> code,
        Optional<String> redirect, Optional<String> errorRedirect,
        Optional<BasicAuth> authOverride) {
      this.provider = provider;
      this.accessToken = accessToken;
      this.code = code;
      this.redirect = redirect;
      this.errorRedirect = errorRedirect;
      this.authOverride = authOverride;
    }

    /**
     * @return Your OAuth Provider ID
     */
    public String getProvider() {
      return provider;
    }

    /**
     * @return Will be passed through your lookup URL to get the user ID. Required if no <code>code</code>.
     */
    public Optional<String> getAccessToken() {
      return accessToken;
    }

    /**
     * @return Will be passed to the OAuth token endpoint to get a token. Required if no <code>accessToken</code>.
     */
    public Optional<String> getCode() {
      return code;
    }

    /**
     * @return Override where the user will navigate to after successfully logging in.
     */
    public Optional<String> getRedirect() {
      return redirect;
    }

    /**
     * @return If an error happens, redirects the user to this url, with at least query parameters <code>code</code>, <code>errorName</code> and <code>message</code>.
     */
    public Optional<String> getErrorRedirect() {
      return errorRedirect;
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
      return provider.equals(other.provider) && accessToken.equals(other.accessToken) && code.equals(other.code) && redirect.equals(other.redirect) && errorRedirect.equals(other.errorRedirect) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.provider, this.accessToken, this.code, this.redirect, this.errorRedirect, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Get.Request{" + "provider: " + provider + ", accessToken: " + accessToken + ", code: " + code + ", redirect: " + redirect + ", errorRedirect: " + errorRedirect + ", authOverride: " + authOverride + "}";
    }

    public static ProviderStage builder() {
      return new Builder();
    }

    public interface ProviderStage {
      _FinalStage provider(String provider);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage accessToken(Optional<String> accessToken);

      _FinalStage accessToken(String accessToken);

      _FinalStage code(Optional<String> code);

      _FinalStage code(String code);

      _FinalStage redirect(Optional<String> redirect);

      _FinalStage redirect(String redirect);

      _FinalStage errorRedirect(Optional<String> errorRedirect);

      _FinalStage errorRedirect(String errorRedirect);

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements ProviderStage, _FinalStage {
      private String provider;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<String> errorRedirect = Optional.empty();

      private Optional<String> redirect = Optional.empty();

      private Optional<String> code = Optional.empty();

      private Optional<String> accessToken = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        provider(other.getProvider());
        accessToken(other.getAccessToken());
        code(other.getCode());
        redirect(other.getRedirect());
        errorRedirect(other.getErrorRedirect());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>Your OAuth Provider ID</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage provider(String provider) {
        this.provider = provider;
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
       * <p>If an error happens, redirects the user to this url, with at least query parameters <code>code</code>, <code>errorName</code> and <code>message</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage errorRedirect(String errorRedirect) {
        this.errorRedirect = Optional.of(errorRedirect);
        return this;
      }

      @Override
      public _FinalStage errorRedirect(Optional<String> errorRedirect) {
        this.errorRedirect = errorRedirect;
        return this;
      }

      /**
       * <p>Override where the user will navigate to after successfully logging in.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage redirect(String redirect) {
        this.redirect = Optional.of(redirect);
        return this;
      }

      @Override
      public _FinalStage redirect(Optional<String> redirect) {
        this.redirect = redirect;
        return this;
      }

      /**
       * <p>Will be passed to the OAuth token endpoint to get a token. Required if no <code>accessToken</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage code(String code) {
        this.code = Optional.of(code);
        return this;
      }

      @Override
      public _FinalStage code(Optional<String> code) {
        this.code = code;
        return this;
      }

      /**
       * <p>Will be passed through your lookup URL to get the user ID. Required if no <code>code</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage accessToken(String accessToken) {
        this.accessToken = Optional.of(accessToken);
        return this;
      }

      @Override
      public _FinalStage accessToken(Optional<String> accessToken) {
        this.accessToken = accessToken;
        return this;
      }

      @Override
      public Request build() {
        return new Request(provider, accessToken, code, redirect, errorRedirect, authOverride);
      }
    }
  }
}
