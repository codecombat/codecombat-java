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
@JsonDeserialize(builder = ClassroomsGetMembersStatsResponseItem.Builder.class)
public final class ClassroomsGetMembersStatsResponseItem {
    private final Optional<String> id;

    private final Optional<ClassroomsGetMembersStatsResponseItemStats> stats;

    private ClassroomsGetMembersStatsResponseItem(
            Optional<String> id, Optional<ClassroomsGetMembersStatsResponseItemStats> stats) {
        this.id = id;
        this.stats = stats;
    }

    @JsonProperty("_id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("stats")
    public Optional<ClassroomsGetMembersStatsResponseItemStats> getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassroomsGetMembersStatsResponseItem
                && equalTo((ClassroomsGetMembersStatsResponseItem) other);
    }

    private boolean equalTo(ClassroomsGetMembersStatsResponseItem other) {
        return id.equals(other.id) && stats.equals(other.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.stats);
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

        private Optional<ClassroomsGetMembersStatsResponseItemStats> stats = Optional.empty();

        private Builder() {}

        public Builder from(ClassroomsGetMembersStatsResponseItem other) {
            id(other.getId());
            stats(other.getStats());
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

        @JsonSetter(value = "stats", nulls = Nulls.SKIP)
        public Builder stats(Optional<ClassroomsGetMembersStatsResponseItemStats> stats) {
            this.stats = stats;
            return this;
        }

        public Builder stats(ClassroomsGetMembersStatsResponseItemStats stats) {
            this.stats = Optional.of(stats);
            return this;
        }

        public ClassroomsGetMembersStatsResponseItem build() {
            return new ClassroomsGetMembersStatsResponseItem(id, stats);
        }
    }
}
