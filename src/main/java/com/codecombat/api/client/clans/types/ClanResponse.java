package com.codecombat.api.client.clans.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ClanResponse.Builder.class
)
public final class ClanResponse {
  private final Optional<String> id;

  private final Optional<String> name;

  private final Optional<String> displayName;

  private final Optional<List<String>> members;

  private final Optional<String> ownerId;

  private final Optional<String> description;

  private final Optional<String> type;

  private final Optional<String> kind;

  private final Optional<Map<String, Object>> metadata;

  private int _cachedHashCode;

  ClanResponse(Optional<String> id, Optional<String> name, Optional<String> displayName,
      Optional<List<String>> members, Optional<String> ownerId, Optional<String> description,
      Optional<String> type, Optional<String> kind, Optional<Map<String, Object>> metadata) {
    this.id = id;
    this.name = name;
    this.displayName = displayName;
    this.members = members;
    this.ownerId = ownerId;
    this.description = description;
    this.type = type;
    this.kind = kind;
    this.metadata = metadata;
  }

  @JsonProperty("_id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  @JsonProperty("displayName")
  public Optional<String> getDisplayName() {
    return displayName;
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

  @JsonProperty("type")
  public Optional<String> getType() {
    return type;
  }

  @JsonProperty("kind")
  public Optional<String> getKind() {
    return kind;
  }

  @JsonProperty("metadata")
  public Optional<Map<String, Object>> getMetadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ClanResponse && equalTo((ClanResponse) other);
  }

  private boolean equalTo(ClanResponse other) {
    return id.equals(other.id) && name.equals(other.name) && displayName.equals(other.displayName) && members.equals(other.members) && ownerId.equals(other.ownerId) && description.equals(other.description) && type.equals(other.type) && kind.equals(other.kind) && metadata.equals(other.metadata);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.name, this.displayName, this.members, this.ownerId, this.description, this.type, this.kind, this.metadata);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ClanResponse{" + "id: " + id + ", name: " + name + ", displayName: " + displayName + ", members: " + members + ", ownerId: " + ownerId + ", description: " + description + ", type: " + type + ", kind: " + kind + ", metadata: " + metadata + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> id = Optional.empty();

    private Optional<String> name = Optional.empty();

    private Optional<String> displayName = Optional.empty();

    private Optional<List<String>> members = Optional.empty();

    private Optional<String> ownerId = Optional.empty();

    private Optional<String> description = Optional.empty();

    private Optional<String> type = Optional.empty();

    private Optional<String> kind = Optional.empty();

    private Optional<Map<String, Object>> metadata = Optional.empty();

    private Builder() {
    }

    public Builder from(ClanResponse other) {
      id(other.getId());
      name(other.getName());
      displayName(other.getDisplayName());
      members(other.getMembers());
      ownerId(other.getOwnerId());
      description(other.getDescription());
      type(other.getType());
      kind(other.getKind());
      metadata(other.getMetadata());
      return this;
    }

    @JsonSetter(
        value = "_id",
        nulls = Nulls.SKIP
    )
    public Builder id(Optional<String> id) {
      this.id = id;
      return this;
    }

    public Builder id(String id) {
      this.id = Optional.of(id);
      return this;
    }

    @JsonSetter(
        value = "name",
        nulls = Nulls.SKIP
    )
    public Builder name(Optional<String> name) {
      this.name = name;
      return this;
    }

    public Builder name(String name) {
      this.name = Optional.of(name);
      return this;
    }

    @JsonSetter(
        value = "displayName",
        nulls = Nulls.SKIP
    )
    public Builder displayName(Optional<String> displayName) {
      this.displayName = displayName;
      return this;
    }

    public Builder displayName(String displayName) {
      this.displayName = Optional.of(displayName);
      return this;
    }

    @JsonSetter(
        value = "members",
        nulls = Nulls.SKIP
    )
    public Builder members(Optional<List<String>> members) {
      this.members = members;
      return this;
    }

    public Builder members(List<String> members) {
      this.members = Optional.of(members);
      return this;
    }

    @JsonSetter(
        value = "ownerID",
        nulls = Nulls.SKIP
    )
    public Builder ownerId(Optional<String> ownerId) {
      this.ownerId = ownerId;
      return this;
    }

    public Builder ownerId(String ownerId) {
      this.ownerId = Optional.of(ownerId);
      return this;
    }

    @JsonSetter(
        value = "description",
        nulls = Nulls.SKIP
    )
    public Builder description(Optional<String> description) {
      this.description = description;
      return this;
    }

    public Builder description(String description) {
      this.description = Optional.of(description);
      return this;
    }

    @JsonSetter(
        value = "type",
        nulls = Nulls.SKIP
    )
    public Builder type(Optional<String> type) {
      this.type = type;
      return this;
    }

    public Builder type(String type) {
      this.type = Optional.of(type);
      return this;
    }

    @JsonSetter(
        value = "kind",
        nulls = Nulls.SKIP
    )
    public Builder kind(Optional<String> kind) {
      this.kind = kind;
      return this;
    }

    public Builder kind(String kind) {
      this.kind = Optional.of(kind);
      return this;
    }

    @JsonSetter(
        value = "metadata",
        nulls = Nulls.SKIP
    )
    public Builder metadata(Optional<Map<String, Object>> metadata) {
      this.metadata = metadata;
      return this;
    }

    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = Optional.of(metadata);
      return this;
    }

    public ClanResponse build() {
      return new ClanResponse(id, name, displayName, members, ownerId, description, type, kind, metadata);
    }
  }
}
