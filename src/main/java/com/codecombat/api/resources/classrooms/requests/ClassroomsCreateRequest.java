package com.codecombat.api.resources.classrooms.requests;

import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.types.ClassroomsCreateRequestAceConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClassroomsCreateRequest.Builder.class)
public final class ClassroomsCreateRequest {
    private final String name;

    private final String ownerId;

    private final ClassroomsCreateRequestAceConfig aceConfig;

    private ClassroomsCreateRequest(String name, String ownerId, ClassroomsCreateRequestAceConfig aceConfig) {
        this.name = name;
        this.ownerId = ownerId;
        this.aceConfig = aceConfig;
    }

    /**
     * @return Name of the classroom
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("ownerID")
    public String getOwnerId() {
        return ownerId;
    }

    @JsonProperty("aceConfig")
    public ClassroomsCreateRequestAceConfig getAceConfig() {
        return aceConfig;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsCreateRequest && equalTo((ClassroomsCreateRequest) other);
    }

    private boolean equalTo(ClassroomsCreateRequest other) {
        return name.equals(other.name) && ownerId.equals(other.ownerId) && aceConfig.equals(other.aceConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.ownerId, this.aceConfig);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        OwnerIdStage name(String name);

        Builder from(ClassroomsCreateRequest other);
    }

    public interface OwnerIdStage {
        AceConfigStage ownerId(String ownerId);
    }

    public interface AceConfigStage {
        _FinalStage aceConfig(ClassroomsCreateRequestAceConfig aceConfig);
    }

    public interface _FinalStage {
        ClassroomsCreateRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, OwnerIdStage, AceConfigStage, _FinalStage {
        private String name;

        private String ownerId;

        private ClassroomsCreateRequestAceConfig aceConfig;

        private Builder() {}

        @Override
        public Builder from(ClassroomsCreateRequest other) {
            name(other.getName());
            ownerId(other.getOwnerId());
            aceConfig(other.getAceConfig());
            return this;
        }

        /**
         * <p>Name of the classroom</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public OwnerIdStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("ownerID")
        public AceConfigStage ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        @Override
        @JsonSetter("aceConfig")
        public _FinalStage aceConfig(ClassroomsCreateRequestAceConfig aceConfig) {
            this.aceConfig = aceConfig;
            return this;
        }

        @Override
        public ClassroomsCreateRequest build() {
            return new ClassroomsCreateRequest(name, ownerId, aceConfig);
        }
    }
}
