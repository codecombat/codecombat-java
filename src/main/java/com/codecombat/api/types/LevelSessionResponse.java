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
@JsonDeserialize(builder = LevelSessionResponse.Builder.class)
public final class LevelSessionResponse {
    private final Optional<LevelSessionResponseState> state;

    private final Optional<LevelSessionResponseLevel> level;

    private final Optional<String> levelId;

    private final Optional<String> creator;

    private final Optional<Integer> playtime;

    private final Optional<String> changed;

    private final Optional<String> created;

    private final Optional<String> dateFirstCompleted;

    private final Optional<Boolean> submitted;

    private final Optional<Boolean> published;

    private LevelSessionResponse(
            Optional<LevelSessionResponseState> state,
            Optional<LevelSessionResponseLevel> level,
            Optional<String> levelId,
            Optional<String> creator,
            Optional<Integer> playtime,
            Optional<String> changed,
            Optional<String> created,
            Optional<String> dateFirstCompleted,
            Optional<Boolean> submitted,
            Optional<Boolean> published) {
        this.state = state;
        this.level = level;
        this.levelId = levelId;
        this.creator = creator;
        this.playtime = playtime;
        this.changed = changed;
        this.created = created;
        this.dateFirstCompleted = dateFirstCompleted;
        this.submitted = submitted;
        this.published = published;
    }

    @JsonProperty("state")
    public Optional<LevelSessionResponseState> getState() {
        return state;
    }

    @JsonProperty("level")
    public Optional<LevelSessionResponseLevel> getLevel() {
        return level;
    }

    /**
     * @return Level slug like <code>wakka-maul</code>
     */
    @JsonProperty("levelID")
    public Optional<String> getLevelId() {
        return levelId;
    }

    @JsonProperty("creator")
    public Optional<String> getCreator() {
        return creator;
    }

    /**
     * @return Time played in seconds.
     */
    @JsonProperty("playtime")
    public Optional<Integer> getPlaytime() {
        return playtime;
    }

    @JsonProperty("changed")
    public Optional<String> getChanged() {
        return changed;
    }

    @JsonProperty("created")
    public Optional<String> getCreated() {
        return created;
    }

    @JsonProperty("dateFirstCompleted")
    public Optional<String> getDateFirstCompleted() {
        return dateFirstCompleted;
    }

    /**
     * @return For arenas. Whether or not the level has been added to the ladder.
     */
    @JsonProperty("submitted")
    public Optional<Boolean> getSubmitted() {
        return submitted;
    }

    /**
     * @return For shareable projects. Whether or not the project has been shared with classmates.
     */
    @JsonProperty("published")
    public Optional<Boolean> getPublished() {
        return published;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LevelSessionResponse && equalTo((LevelSessionResponse) other);
    }

    private boolean equalTo(LevelSessionResponse other) {
        return state.equals(other.state)
                && level.equals(other.level)
                && levelId.equals(other.levelId)
                && creator.equals(other.creator)
                && playtime.equals(other.playtime)
                && changed.equals(other.changed)
                && created.equals(other.created)
                && dateFirstCompleted.equals(other.dateFirstCompleted)
                && submitted.equals(other.submitted)
                && published.equals(other.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.state,
                this.level,
                this.levelId,
                this.creator,
                this.playtime,
                this.changed,
                this.created,
                this.dateFirstCompleted,
                this.submitted,
                this.published);
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
        private Optional<LevelSessionResponseState> state = Optional.empty();

        private Optional<LevelSessionResponseLevel> level = Optional.empty();

        private Optional<String> levelId = Optional.empty();

        private Optional<String> creator = Optional.empty();

        private Optional<Integer> playtime = Optional.empty();

        private Optional<String> changed = Optional.empty();

        private Optional<String> created = Optional.empty();

        private Optional<String> dateFirstCompleted = Optional.empty();

        private Optional<Boolean> submitted = Optional.empty();

        private Optional<Boolean> published = Optional.empty();

        private Builder() {}

        public Builder from(LevelSessionResponse other) {
            state(other.getState());
            level(other.getLevel());
            levelId(other.getLevelId());
            creator(other.getCreator());
            playtime(other.getPlaytime());
            changed(other.getChanged());
            created(other.getCreated());
            dateFirstCompleted(other.getDateFirstCompleted());
            submitted(other.getSubmitted());
            published(other.getPublished());
            return this;
        }

        @JsonSetter(value = "state", nulls = Nulls.SKIP)
        public Builder state(Optional<LevelSessionResponseState> state) {
            this.state = state;
            return this;
        }

        public Builder state(LevelSessionResponseState state) {
            this.state = Optional.of(state);
            return this;
        }

        @JsonSetter(value = "level", nulls = Nulls.SKIP)
        public Builder level(Optional<LevelSessionResponseLevel> level) {
            this.level = level;
            return this;
        }

        public Builder level(LevelSessionResponseLevel level) {
            this.level = Optional.of(level);
            return this;
        }

        @JsonSetter(value = "levelID", nulls = Nulls.SKIP)
        public Builder levelId(Optional<String> levelId) {
            this.levelId = levelId;
            return this;
        }

        public Builder levelId(String levelId) {
            this.levelId = Optional.of(levelId);
            return this;
        }

        @JsonSetter(value = "creator", nulls = Nulls.SKIP)
        public Builder creator(Optional<String> creator) {
            this.creator = creator;
            return this;
        }

        public Builder creator(String creator) {
            this.creator = Optional.of(creator);
            return this;
        }

        @JsonSetter(value = "playtime", nulls = Nulls.SKIP)
        public Builder playtime(Optional<Integer> playtime) {
            this.playtime = playtime;
            return this;
        }

        public Builder playtime(Integer playtime) {
            this.playtime = Optional.of(playtime);
            return this;
        }

        @JsonSetter(value = "changed", nulls = Nulls.SKIP)
        public Builder changed(Optional<String> changed) {
            this.changed = changed;
            return this;
        }

        public Builder changed(String changed) {
            this.changed = Optional.of(changed);
            return this;
        }

        @JsonSetter(value = "created", nulls = Nulls.SKIP)
        public Builder created(Optional<String> created) {
            this.created = created;
            return this;
        }

        public Builder created(String created) {
            this.created = Optional.of(created);
            return this;
        }

        @JsonSetter(value = "dateFirstCompleted", nulls = Nulls.SKIP)
        public Builder dateFirstCompleted(Optional<String> dateFirstCompleted) {
            this.dateFirstCompleted = dateFirstCompleted;
            return this;
        }

        public Builder dateFirstCompleted(String dateFirstCompleted) {
            this.dateFirstCompleted = Optional.of(dateFirstCompleted);
            return this;
        }

        @JsonSetter(value = "submitted", nulls = Nulls.SKIP)
        public Builder submitted(Optional<Boolean> submitted) {
            this.submitted = submitted;
            return this;
        }

        public Builder submitted(Boolean submitted) {
            this.submitted = Optional.of(submitted);
            return this;
        }

        @JsonSetter(value = "published", nulls = Nulls.SKIP)
        public Builder published(Optional<Boolean> published) {
            this.published = published;
            return this;
        }

        public Builder published(Boolean published) {
            this.published = Optional.of(published);
            return this;
        }

        public LevelSessionResponse build() {
            return new LevelSessionResponse(
                    state,
                    level,
                    levelId,
                    creator,
                    playtime,
                    changed,
                    created,
                    dateFirstCompleted,
                    submitted,
                    published);
        }
    }
}
