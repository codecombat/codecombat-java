package com.codecombat.api.resources.auth.requests;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LoginOauthRequest.Builder.class)
public final class LoginOauthRequest {
    private final String provider;

    private final Optional<String> accessToken;

    private final Optional<String> code;

    private final Optional<String> redirect;

    private final Optional<String> errorRedirect;

    private LoginOauthRequest(
            String provider,
            Optional<String> accessToken,
            Optional<String> code,
            Optional<String> redirect,
            Optional<String> errorRedirect) {
        this.provider = provider;
        this.accessToken = accessToken;
        this.code = code;
        this.redirect = redirect;
        this.errorRedirect = errorRedirect;
    }

    /**
     * @return Your OAuth Provider ID
     */
    @JsonProperty("provider")
    public String getProvider() {
        return provider;
    }

    /**
     * @return Will be passed through your lookup URL to get the user ID. Required if no <code>code</code>.
     */
    @JsonProperty("accessToken")
    public Optional<String> getAccessToken() {
        return accessToken;
    }

    /**
     * @return Will be passed to the OAuth token endpoint to get a token. Required if no <code>accessToken</code>.
     */
    @JsonProperty("code")
    public Optional<String> getCode() {
        return code;
    }

    /**
     * @return Override where the user will navigate to after successfully logging in.
     */
    @JsonProperty("redirect")
    public Optional<String> getRedirect() {
        return redirect;
    }

    /**
     * @return If an error happens, redirects the user to this url, with at least query parameters <code>code</code>, <code>errorName</code> and <code>message</code>.
     */
    @JsonProperty("errorRedirect")
    public Optional<String> getErrorRedirect() {
        return errorRedirect;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoginOauthRequest && equalTo((LoginOauthRequest) other);
    }

    private boolean equalTo(LoginOauthRequest other) {
        return provider.equals(other.provider)
                && accessToken.equals(other.accessToken)
                && code.equals(other.code)
                && redirect.equals(other.redirect)
                && errorRedirect.equals(other.errorRedirect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.provider, this.accessToken, this.code, this.redirect, this.errorRedirect);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ProviderStage builder() {
        return new Builder();
    }

    public interface ProviderStage {
        _FinalStage provider(String provider);

        Builder from(LoginOauthRequest other);
    }

    public interface _FinalStage {
        LoginOauthRequest build();

        _FinalStage accessToken(Optional<String> accessToken);

        _FinalStage accessToken(String accessToken);

        _FinalStage code(Optional<String> code);

        _FinalStage code(String code);

        _FinalStage redirect(Optional<String> redirect);

        _FinalStage redirect(String redirect);

        _FinalStage errorRedirect(Optional<String> errorRedirect);

        _FinalStage errorRedirect(String errorRedirect);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ProviderStage, _FinalStage {
        private String provider;

        private Optional<String> errorRedirect = Optional.empty();

        private Optional<String> redirect = Optional.empty();

        private Optional<String> code = Optional.empty();

        private Optional<String> accessToken = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(LoginOauthRequest other) {
            provider(other.getProvider());
            accessToken(other.getAccessToken());
            code(other.getCode());
            redirect(other.getRedirect());
            errorRedirect(other.getErrorRedirect());
            return this;
        }

        /**
         * <p>Your OAuth Provider ID</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("provider")
        public _FinalStage provider(String provider) {
            this.provider = provider;
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
        @JsonSetter(value = "errorRedirect", nulls = Nulls.SKIP)
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
        @JsonSetter(value = "redirect", nulls = Nulls.SKIP)
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
        @JsonSetter(value = "code", nulls = Nulls.SKIP)
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
        @JsonSetter(value = "accessToken", nulls = Nulls.SKIP)
        public _FinalStage accessToken(Optional<String> accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @Override
        public LoginOauthRequest build() {
            return new LoginOauthRequest(provider, accessToken, code, redirect, errorRedirect);
        }
    }
}
