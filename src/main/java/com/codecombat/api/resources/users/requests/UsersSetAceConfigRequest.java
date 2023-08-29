package com.codecombat.api.resources.users.requests;

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
@JsonDeserialize(builder = UsersSetAceConfigRequest.Builder.class)
public final class UsersSetAceConfigRequest {
    private final Optional<Boolean> liveCompletion;

    private final Optional<Boolean> behaviors;

    private final Optional<String> language;

    private UsersSetAceConfigRequest(
            Optional<Boolean> liveCompletion, Optional<Boolean> behaviors, Optional<String> language) {
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
        return other instanceof UsersSetAceConfigRequest && equalTo((UsersSetAceConfigRequest) other);
    }

    private boolean equalTo(UsersSetAceConfigRequest other) {
        return liveCompletion.equals(other.liveCompletion)
                && behaviors.equals(other.behaviors)
                && language.equals(other.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.liveCompletion, this.behaviors, this.language);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> liveCompletion = Optional.empty();

        private Optional<Boolean> behaviors = Optional.empty();

        private Optional<String> language = Optional.empty();

        private Builder() {}

        public Builder from(UsersSetAceConfigRequest other) {
            liveCompletion(other.getLiveCompletion());
            behaviors(other.getBehaviors());
            language(other.getLanguage());
            return this;
        }

        @JsonSetter(value = "liveCompletion", nulls = Nulls.SKIP)
        public Builder liveCompletion(Optional<Boolean> liveCompletion) {
            this.liveCompletion = liveCompletion;
            return this;
        }

        public Builder liveCompletion(Boolean liveCompletion) {
            this.liveCompletion = Optional.of(liveCompletion);
            return this;
        }

        @JsonSetter(value = "behaviors", nulls = Nulls.SKIP)
        public Builder behaviors(Optional<Boolean> behaviors) {
            this.behaviors = behaviors;
            return this;
        }

        public Builder behaviors(Boolean behaviors) {
            this.behaviors = Optional.of(behaviors);
            return this;
        }

        @JsonSetter(value = "language", nulls = Nulls.SKIP)
        public Builder language(Optional<String> language) {
            this.language = language;
            return this;
        }

        public Builder language(String language) {
            this.language = Optional.of(language);
            return this;
        }

        public UsersSetAceConfigRequest build() {
            return new UsersSetAceConfigRequest(liveCompletion, behaviors, language);
        }
    }
}
