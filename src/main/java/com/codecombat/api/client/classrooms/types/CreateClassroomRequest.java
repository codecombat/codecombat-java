package com.codecombat.api.client.classrooms.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateClassroomRequest.Builder.class
)
public final class CreateClassroomRequest {
  private final String name;

  private final String ownerId;

  private final AceConfig aceConfig;

  private int _cachedHashCode;

  CreateClassroomRequest(String name, String ownerId, AceConfig aceConfig) {
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
  public AceConfig getAceConfig() {
    return aceConfig;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateClassroomRequest && equalTo((CreateClassroomRequest) other);
  }

  private boolean equalTo(CreateClassroomRequest other) {
    return name.equals(other.name) && ownerId.equals(other.ownerId) && aceConfig.equals(other.aceConfig);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.ownerId, this.aceConfig);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateClassroomRequest{" + "name: " + name + ", ownerId: " + ownerId + ", aceConfig: " + aceConfig + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    OwnerIdStage name(String name);

    Builder from(CreateClassroomRequest other);
  }

  public interface OwnerIdStage {
    AceConfigStage ownerId(String ownerId);
  }

  public interface AceConfigStage {
    _FinalStage aceConfig(AceConfig aceConfig);
  }

  public interface _FinalStage {
    CreateClassroomRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, OwnerIdStage, AceConfigStage, _FinalStage {
    private String name;

    private String ownerId;

    private AceConfig aceConfig;

    private Builder() {
    }

    @Override
    public Builder from(CreateClassroomRequest other) {
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
    public _FinalStage aceConfig(AceConfig aceConfig) {
      this.aceConfig = aceConfig;
      return this;
    }

    @Override
    public CreateClassroomRequest build() {
      return new CreateClassroomRequest(name, ownerId, aceConfig);
    }
  }
}
