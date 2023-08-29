package com.codecombat.api.types;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClassroomResponseWithCodeCoursesItem.Builder.class)
public final class ClassroomResponseWithCodeCoursesItem {
    private final Optional<String> id;

    private final Optional<List<Map<String, Object>>> levels;

    private final Optional<List<String>> enrolled;

    private final Optional<String> instanceId;

    private ClassroomResponseWithCodeCoursesItem(
            Optional<String> id,
            Optional<List<Map<String, Object>>> levels,
            Optional<List<String>> enrolled,
            Optional<String> instanceId) {
        this.id = id;
        this.levels = levels;
        this.enrolled = enrolled;
        this.instanceId = instanceId;
    }

    @JsonProperty("_id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("levels")
    public Optional<List<Map<String, Object>>> getLevels() {
        return levels;
    }

    @JsonProperty("enrolled")
    public Optional<List<String>> getEnrolled() {
        return enrolled;
    }

    @JsonProperty("instance_id")
    public Optional<String> getInstanceId() {
        return instanceId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomResponseWithCodeCoursesItem
                && equalTo((ClassroomResponseWithCodeCoursesItem) other);
    }

    private boolean equalTo(ClassroomResponseWithCodeCoursesItem other) {
        return id.equals(other.id)
                && levels.equals(other.levels)
                && enrolled.equals(other.enrolled)
                && instanceId.equals(other.instanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.levels, this.enrolled, this.instanceId);
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
        private Optional<String> id = Optional.empty();

        private Optional<List<Map<String, Object>>> levels = Optional.empty();

        private Optional<List<String>> enrolled = Optional.empty();

        private Optional<String> instanceId = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomResponseWithCodeCoursesItem other) {
            id(other.getId());
            levels(other.getLevels());
            enrolled(other.getEnrolled());
            instanceId(other.getInstanceId());
            return this;
        }

        @JsonSetter(value = "_id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "levels", nulls = Nulls.SKIP)
        public Builder levels(Optional<List<Map<String, Object>>> levels) {
            this.levels = levels;
            return this;
        }

        public Builder levels(List<Map<String, Object>> levels) {
            this.levels = Optional.of(levels);
            return this;
        }

        @JsonSetter(value = "enrolled", nulls = Nulls.SKIP)
        public Builder enrolled(Optional<List<String>> enrolled) {
            this.enrolled = enrolled;
            return this;
        }

        public Builder enrolled(List<String> enrolled) {
            this.enrolled = Optional.of(enrolled);
            return this;
        }

        @JsonSetter(value = "instance_id", nulls = Nulls.SKIP)
        public Builder instanceId(Optional<String> instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        public Builder instanceId(String instanceId) {
            this.instanceId = Optional.of(instanceId);
            return this;
        }

        public ClassroomResponseWithCodeCoursesItem build() {
            return new ClassroomResponseWithCodeCoursesItem(id, levels, enrolled, instanceId);
        }
    }
}
