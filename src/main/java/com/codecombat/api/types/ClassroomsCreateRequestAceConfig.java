package com.codecombat.api.types;

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
@JsonDeserialize(builder = ClassroomsCreateRequestAceConfig.Builder.class)
public final class ClassroomsCreateRequestAceConfig {
    private final Optional<String> language;

    private ClassroomsCreateRequestAceConfig(Optional<String> language) {
        this.language = language;
    }

    /**
     * @return Programming language for the classroom
     */
    @JsonProperty("language")
    public Optional<String> getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsCreateRequestAceConfig && equalTo((ClassroomsCreateRequestAceConfig) other);
    }

    private boolean equalTo(ClassroomsCreateRequestAceConfig other) {
        return language.equals(other.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.language);
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
        private Optional<String> language = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomsCreateRequestAceConfig other) {
            language(other.getLanguage());
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

        public ClassroomsCreateRequestAceConfig build() {
            return new ClassroomsCreateRequestAceConfig(language);
        }
    }
}
