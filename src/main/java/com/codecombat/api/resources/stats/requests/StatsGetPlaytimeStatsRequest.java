package com.codecombat.api.resources.stats.requests;

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
@JsonDeserialize(builder = StatsGetPlaytimeStatsRequest.Builder.class)
public final class StatsGetPlaytimeStatsRequest {
    private final Optional<String> startDate;

    private final Optional<String> endDate;

    private final Optional<String> country;

    private StatsGetPlaytimeStatsRequest(
            Optional<String> startDate, Optional<String> endDate, Optional<String> country) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
    }

    /**
     * @return Earliest an included user was created
     */
    @JsonProperty("startDate")
    public Optional<String> getStartDate() {
        return startDate;
    }

    /**
     * @return Latest an included user was created
     */
    @JsonProperty("endDate")
    public Optional<String> getEndDate() {
        return endDate;
    }

    /**
     * @return Filter by country string
     */
    @JsonProperty("country")
    public Optional<String> getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StatsGetPlaytimeStatsRequest && equalTo((StatsGetPlaytimeStatsRequest) other);
    }

    private boolean equalTo(StatsGetPlaytimeStatsRequest other) {
        return startDate.equals(other.startDate) && endDate.equals(other.endDate) && country.equals(other.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.startDate, this.endDate, this.country);
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
        private Optional<String> startDate = Optional.empty();

        private Optional<String> endDate = Optional.empty();

        private Optional<String> country = Optional.empty();

        private Builder() {}

        public Builder from(StatsGetPlaytimeStatsRequest other) {
            startDate(other.getStartDate());
            endDate(other.getEndDate());
            country(other.getCountry());
            return this;
        }

        @JsonSetter(value = "startDate", nulls = Nulls.SKIP)
        public Builder startDate(Optional<String> startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = Optional.of(startDate);
            return this;
        }

        @JsonSetter(value = "endDate", nulls = Nulls.SKIP)
        public Builder endDate(Optional<String> endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = Optional.of(endDate);
            return this;
        }

        @JsonSetter(value = "country", nulls = Nulls.SKIP)
        public Builder country(Optional<String> country) {
            this.country = country;
            return this;
        }

        public Builder country(String country) {
            this.country = Optional.of(country);
            return this;
        }

        public StatsGetPlaytimeStatsRequest build() {
            return new StatsGetPlaytimeStatsRequest(startDate, endDate, country);
        }
    }
}
