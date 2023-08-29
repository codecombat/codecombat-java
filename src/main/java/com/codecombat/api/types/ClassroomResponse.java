package com.codecombat.api.types;

import com.codecombat.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClassroomResponse.Builder.class)
public final class ClassroomResponse {
    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<List<String>> members;

    private final Optional<String> ownerId;

    private final Optional<String> description;

    private final Optional<List<ClassroomResponseCoursesItem>> courses;

    private ClassroomResponse(
            Optional<String> id,
            Optional<String> name,
            Optional<List<String>> members,
            Optional<String> ownerId,
            Optional<String> description,
            Optional<List<ClassroomResponseCoursesItem>> courses) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.ownerId = ownerId;
        this.description = description;
        this.courses = courses;
    }

    @JsonProperty("_id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("members")
    public Optional<List<String>> getMembers() {
        return members;
    }

    @JsonProperty("ownerID")
    public Optional<String> getOwnerId() {
        return ownerId;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("courses")
    public Optional<List<ClassroomResponseCoursesItem>> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomResponse && equalTo((ClassroomResponse) other);
    }

    private boolean equalTo(ClassroomResponse other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && members.equals(other.members)
                && ownerId.equals(other.ownerId)
                && description.equals(other.description)
                && courses.equals(other.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.members, this.ownerId, this.description, this.courses);
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

        private Optional<String> name = Optional.empty();

        private Optional<List<String>> members = Optional.empty();

        private Optional<String> ownerId = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<List<ClassroomResponseCoursesItem>> courses = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomResponse other) {
            id(other.getId());
            name(other.getName());
            members(other.getMembers());
            ownerId(other.getOwnerId());
            description(other.getDescription());
            courses(other.getCourses());
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "members", nulls = Nulls.SKIP)
        public Builder members(Optional<List<String>> members) {
            this.members = members;
            return this;
        }

        public Builder members(List<String> members) {
            this.members = Optional.of(members);
            return this;
        }

        @JsonSetter(value = "ownerID", nulls = Nulls.SKIP)
        public Builder ownerId(Optional<String> ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder ownerId(String ownerId) {
            this.ownerId = Optional.of(ownerId);
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "courses", nulls = Nulls.SKIP)
        public Builder courses(Optional<List<ClassroomResponseCoursesItem>> courses) {
            this.courses = courses;
            return this;
        }

        public Builder courses(List<ClassroomResponseCoursesItem> courses) {
            this.courses = Optional.of(courses);
            return this;
        }

        public ClassroomResponse build() {
            return new ClassroomResponse(id, name, members, ownerId, description, courses);
        }
    }
}
