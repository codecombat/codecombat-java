package com.codecombat.api.client.classrooms.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetLevelSession {
  private GetLevelSession() {
  }

  public static final class Request {
    private final String classroomHandle;

    private final String memberHandle;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String classroomHandle, String memberHandle, Optional<BasicAuth> authOverride) {
      this.classroomHandle = classroomHandle;
      this.memberHandle = memberHandle;
      this.authOverride = authOverride;
    }

    /**
     * @return The classroom's <code>_id</code>.
     */
    public String getClassroomHandle() {
      return classroomHandle;
    }

    /**
     * @return The classroom member's <code>_id</code>.
     */
    public String getMemberHandle() {
      return memberHandle;
    }

    public Optional<BasicAuth> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return classroomHandle.equals(other.classroomHandle) && memberHandle.equals(other.memberHandle) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.classroomHandle, this.memberHandle, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetLevelSession.Request{" + "classroomHandle: " + classroomHandle + ", memberHandle: " + memberHandle + ", authOverride: " + authOverride + "}";
    }

    public static ClassroomHandleStage builder() {
      return new Builder();
    }

    public interface ClassroomHandleStage {
      MemberHandleStage classroomHandle(String classroomHandle);

      Builder from(Request other);
    }

    public interface MemberHandleStage {
      _FinalStage memberHandle(String memberHandle);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements ClassroomHandleStage, MemberHandleStage, _FinalStage {
      private String classroomHandle;

      private String memberHandle;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        classroomHandle(other.getClassroomHandle());
        memberHandle(other.getMemberHandle());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The classroom's <code>_id</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public MemberHandleStage classroomHandle(String classroomHandle) {
        this.classroomHandle = classroomHandle;
        return this;
      }

      /**
       * <p>The classroom member's <code>_id</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage memberHandle(String memberHandle) {
        this.memberHandle = memberHandle;
        return this;
      }

      @Override
      public _FinalStage authOverride(BasicAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BasicAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(classroomHandle, memberHandle, authOverride);
      }
    }
  }
}
