package com.codecombat.api.resources.classrooms.requests;

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
@JsonDeserialize(builder = ClassroomsGetMembersStatsRequest.Builder.class)
public final class ClassroomsGetMembersStatsRequest {
    private final Optional<String> project;

    private final Optional<Double> memberLimit;

    private final Optional<Double> memberSkip;

    private ClassroomsGetMembersStatsRequest(
            Optional<String> project, Optional<Double> memberLimit, Optional<Double> memberSkip) {
        this.project = project;
        this.memberLimit = memberLimit;
        this.memberSkip = memberSkip;
    }

    /**
     * @return If specified, include only the specified projection of returned stats; else, return all stats. Format as a comma-separated list, like <code>creator,playtime,state.complete</code>.
     */
    @JsonProperty("project")
    public Optional<String> getProject() {
        return project;
    }

    /**
     * @return Limit the return member number. the default value is 10, and the max value is 100
     */
    @JsonProperty("memberLimit")
    public Optional<Double> getMemberLimit() {
        return memberLimit;
    }

    /**
     * @return Skip the members that doesn't need to return, for pagination
     */
    @JsonProperty("memberSkip")
    public Optional<Double> getMemberSkip() {
        return memberSkip;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsGetMembersStatsRequest && equalTo((ClassroomsGetMembersStatsRequest) other);
    }

    private boolean equalTo(ClassroomsGetMembersStatsRequest other) {
        return project.equals(other.project)
                && memberLimit.equals(other.memberLimit)
                && memberSkip.equals(other.memberSkip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.project, this.memberLimit, this.memberSkip);
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
        private Optional<String> project = Optional.empty();

        private Optional<Double> memberLimit = Optional.empty();

        private Optional<Double> memberSkip = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomsGetMembersStatsRequest other) {
            project(other.getProject());
            memberLimit(other.getMemberLimit());
            memberSkip(other.getMemberSkip());
            return this;
        }

        @JsonSetter(value = "project", nulls = Nulls.SKIP)
        public Builder project(Optional<String> project) {
            this.project = project;
            return this;
        }

        public Builder project(String project) {
            this.project = Optional.of(project);
            return this;
        }

        @JsonSetter(value = "memberLimit", nulls = Nulls.SKIP)
        public Builder memberLimit(Optional<Double> memberLimit) {
            this.memberLimit = memberLimit;
            return this;
        }

        public Builder memberLimit(Double memberLimit) {
            this.memberLimit = Optional.of(memberLimit);
            return this;
        }

        @JsonSetter(value = "memberSkip", nulls = Nulls.SKIP)
        public Builder memberSkip(Optional<Double> memberSkip) {
            this.memberSkip = memberSkip;
            return this;
        }

        public Builder memberSkip(Double memberSkip) {
            this.memberSkip = Optional.of(memberSkip);
            return this;
        }

        public ClassroomsGetMembersStatsRequest build() {
            return new ClassroomsGetMembersStatsRequest(project, memberLimit, memberSkip);
        }
    }
}
