package com.codecombat.api.client.classrooms.endpoints;

import com.codecombat.api.core.BasicAuth;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class GetMembersStats {
  private GetMembersStats() {
  }

  public static final class Request {
    private final String classroomHandle;

    private final Optional<String> project;

    private final Optional<Double> memberLimit;

    private final Optional<Double> memberSkip;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String classroomHandle, Optional<String> project, Optional<Double> memberLimit,
        Optional<Double> memberSkip, Optional<BasicAuth> authOverride) {
      this.classroomHandle = classroomHandle;
      this.project = project;
      this.memberLimit = memberLimit;
      this.memberSkip = memberSkip;
      this.authOverride = authOverride;
    }

    /**
     * @return The classroom's <code>_id</code>.
     */
    public String getClassroomHandle() {
      return classroomHandle;
    }

    /**
     * @return If specified, include only the specified projection of returned stats; else, return all stats. Format as a comma-separated list, like <code>creator,playtime,state.complete</code>.
     */
    public Optional<String> getProject() {
      return project;
    }

    /**
     * @return Limit the return member number. the default value is 10, and the max value is 100
     */
    public Optional<Double> getMemberLimit() {
      return memberLimit;
    }

    /**
     * @return Skip the members that doesn't need to return, for pagination
     */
    public Optional<Double> getMemberSkip() {
      return memberSkip;
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
      return classroomHandle.equals(other.classroomHandle) && project.equals(other.project) && memberLimit.equals(other.memberLimit) && memberSkip.equals(other.memberSkip) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.classroomHandle, this.project, this.memberLimit, this.memberSkip, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "GetMembersStats.Request{" + "classroomHandle: " + classroomHandle + ", project: " + project + ", memberLimit: " + memberLimit + ", memberSkip: " + memberSkip + ", authOverride: " + authOverride + "}";
    }

    public static ClassroomHandleStage builder() {
      return new Builder();
    }

    public interface ClassroomHandleStage {
      _FinalStage classroomHandle(String classroomHandle);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage project(Optional<String> project);

      _FinalStage project(String project);

      _FinalStage memberLimit(Optional<Double> memberLimit);

      _FinalStage memberLimit(Double memberLimit);

      _FinalStage memberSkip(Optional<Double> memberSkip);

      _FinalStage memberSkip(Double memberSkip);

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements ClassroomHandleStage, _FinalStage {
      private String classroomHandle;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<Double> memberSkip = Optional.empty();

      private Optional<Double> memberLimit = Optional.empty();

      private Optional<String> project = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        classroomHandle(other.getClassroomHandle());
        project(other.getProject());
        memberLimit(other.getMemberLimit());
        memberSkip(other.getMemberSkip());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The classroom's <code>_id</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage classroomHandle(String classroomHandle) {
        this.classroomHandle = classroomHandle;
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

      /**
       * <p>Skip the members that doesn't need to return, for pagination</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage memberSkip(Double memberSkip) {
        this.memberSkip = Optional.of(memberSkip);
        return this;
      }

      @Override
      public _FinalStage memberSkip(Optional<Double> memberSkip) {
        this.memberSkip = memberSkip;
        return this;
      }

      /**
       * <p>Limit the return member number. the default value is 10, and the max value is 100</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage memberLimit(Double memberLimit) {
        this.memberLimit = Optional.of(memberLimit);
        return this;
      }

      @Override
      public _FinalStage memberLimit(Optional<Double> memberLimit) {
        this.memberLimit = memberLimit;
        return this;
      }

      /**
       * <p>If specified, include only the specified projection of returned stats; else, return all stats. Format as a comma-separated list, like <code>creator,playtime,state.complete</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage project(String project) {
        this.project = Optional.of(project);
        return this;
      }

      @Override
      public _FinalStage project(Optional<String> project) {
        this.project = project;
        return this;
      }

      @Override
      public Request build() {
        return new Request(classroomHandle, project, memberLimit, memberSkip, authOverride);
      }
    }
  }
}
