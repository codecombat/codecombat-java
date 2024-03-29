package com.codecombat.api.requests;

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
@JsonDeserialize(builder = PostUsersHandleOAuthIdentitiesRequest.Builder.class)
public final class PostUsersHandleOAuthIdentitiesRequest {
    private final String provider;

    private final Optional<String> accessToken;

    private final Optional<String> code;

    private PostUsersHandleOAuthIdentitiesRequest(
            String provider, Optional<String> accessToken, Optional<String> code) {
        this.provider = provider;
        this.accessToken = accessToken;
        this.code = code;
    }

    /**
     * @return Your OAuth Provider ID.
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PostUsersHandleOAuthIdentitiesRequest
                && equalTo((PostUsersHandleOAuthIdentitiesRequest) other);
    }

    private boolean equalTo(PostUsersHandleOAuthIdentitiesRequest other) {
        return provider.equals(other.provider) && accessToken.equals(other.accessToken) && code.equals(other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.provider, this.accessToken, this.code);
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

        Builder from(PostUsersHandleOAuthIdentitiesRequest other);
    }

    public interface _FinalStage {
        PostUsersHandleOAuthIdentitiesRequest build();

        _FinalStage accessToken(Optional<String> accessToken);

        _FinalStage accessToken(String accessToken);

        _FinalStage code(Optional<String> code);

        _FinalStage code(String code);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ProviderStage, _FinalStage {
        private String provider;

        private Optional<String> code = Optional.empty();

        private Optional<String> accessToken = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(PostUsersHandleOAuthIdentitiesRequest other) {
            provider(other.getProvider());
            accessToken(other.getAccessToken());
            code(other.getCode());
            return this;
        }

        /**
         * <p>Your OAuth Provider ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("provider")
        public _FinalStage provider(String provider) {
            this.provider = provider;
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
        public PostUsersHandleOAuthIdentitiesRequest build() {
            return new PostUsersHandleOAuthIdentitiesRequest(provider, accessToken, code);
        }
    }
}
