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
@JsonDeserialize(builder = ClassroomResponseWithCode.Builder.class)
public final class ClassroomResponseWithCode {
    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<List<String>> members;

    private final Optional<String> ownerId;

    private final Optional<String> description;

    private final Optional<String> code;

    private final Optional<String> codeCamel;

    private final Optional<List<ClassroomResponseWithCodeCoursesItem>> courses;

    private final Optional<String> clanId;

    private ClassroomResponseWithCode(
            Optional<String> id,
            Optional<String> name,
            Optional<List<String>> members,
            Optional<String> ownerId,
            Optional<String> description,
            Optional<String> code,
            Optional<String> codeCamel,
            Optional<List<ClassroomResponseWithCodeCoursesItem>> courses,
            Optional<String> clanId) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.ownerId = ownerId;
        this.description = description;
        this.code = code;
        this.codeCamel = codeCamel;
        this.courses = courses;
        this.clanId = clanId;
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

    @JsonProperty("code")
    public Optional<String> getCode() {
        return code;
    }

    @JsonProperty("codeCamel")
    public Optional<String> getCodeCamel() {
        return codeCamel;
    }

    @JsonProperty("courses")
    public Optional<List<ClassroomResponseWithCodeCoursesItem>> getCourses() {
        return courses;
    }

    @JsonProperty("clanId")
    public Optional<String> getClanId() {
        return clanId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomResponseWithCode && equalTo((ClassroomResponseWithCode) other);
    }

    private boolean equalTo(ClassroomResponseWithCode other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && members.equals(other.members)
                && ownerId.equals(other.ownerId)
                && description.equals(other.description)
                && code.equals(other.code)
                && codeCamel.equals(other.codeCamel)
                && courses.equals(other.courses)
                && clanId.equals(other.clanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.members,
                this.ownerId,
                this.description,
                this.code,
                this.codeCamel,
                this.courses,
                this.clanId);
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

        private Optional<String> code = Optional.empty();

        private Optional<String> codeCamel = Optional.empty();

        private Optional<List<ClassroomResponseWithCodeCoursesItem>> courses = Optional.empty();

        private Optional<String> clanId = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomResponseWithCode other) {
            id(other.getId());
            name(other.getName());
            members(other.getMembers());
            ownerId(other.getOwnerId());
            description(other.getDescription());
            code(other.getCode());
            codeCamel(other.getCodeCamel());
            courses(other.getCourses());
            clanId(other.getClanId());
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

        @JsonSetter(value = "code", nulls = Nulls.SKIP)
        public Builder code(Optional<String> code) {
            this.code = code;
            return this;
        }

        public Builder code(String code) {
            this.code = Optional.of(code);
            return this;
        }

        @JsonSetter(value = "codeCamel", nulls = Nulls.SKIP)
        public Builder codeCamel(Optional<String> codeCamel) {
            this.codeCamel = codeCamel;
            return this;
        }

        public Builder codeCamel(String codeCamel) {
            this.codeCamel = Optional.of(codeCamel);
            return this;
        }

        @JsonSetter(value = "courses", nulls = Nulls.SKIP)
        public Builder courses(Optional<List<ClassroomResponseWithCodeCoursesItem>> courses) {
            this.courses = courses;
            return this;
        }

        public Builder courses(List<ClassroomResponseWithCodeCoursesItem> courses) {
            this.courses = Optional.of(courses);
            return this;
        }

        @JsonSetter(value = "clanId", nulls = Nulls.SKIP)
        public Builder clanId(Optional<String> clanId) {
            this.clanId = clanId;
            return this;
        }

        public Builder clanId(String clanId) {
            this.clanId = Optional.of(clanId);
            return this;
        }

        public ClassroomResponseWithCode build() {
            return new ClassroomResponseWithCode(
                    id, name, members, ownerId, description, code, codeCamel, courses, clanId);
        }
    }
}
