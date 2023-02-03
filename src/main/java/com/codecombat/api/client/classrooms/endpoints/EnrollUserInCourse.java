package com.codecombat.api.client.classrooms.endpoints;

import com.codecombat.api.client.classrooms.types.EnrollUserInCourseRequest;
import com.codecombat.api.core.BasicAuth;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class EnrollUserInCourse {
  private EnrollUserInCourse() {
  }

  public static final class Request {
    private final String classroomHandle;

    private final String courseHandle;

    private final Optional<Double> retMemberLimit;

    private final EnrollUserInCourseRequest body;

    private final Optional<BasicAuth> authOverride;

    private int _cachedHashCode;

    Request(String classroomHandle, String courseHandle, Optional<Double> retMemberLimit,
        EnrollUserInCourseRequest body, Optional<BasicAuth> authOverride) {
      this.classroomHandle = classroomHandle;
      this.courseHandle = courseHandle;
      this.retMemberLimit = retMemberLimit;
      this.body = body;
      this.authOverride = authOverride;
    }

    /**
     * @return The classroom's <code>_id</code>.
     */
    public String getClassroomHandle() {
      return classroomHandle;
    }

    /**
     * @return The course's <code>_id</code>.
     */
    public String getCourseHandle() {
      return courseHandle;
    }

    /**
     * @return limit the return number of members for the classroom, the default value is 1000
     */
    public Optional<Double> getRetMemberLimit() {
      return retMemberLimit;
    }

    public EnrollUserInCourseRequest getBody() {
      return body;
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
      return classroomHandle.equals(other.classroomHandle) && courseHandle.equals(other.courseHandle) && retMemberLimit.equals(other.retMemberLimit) && body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.classroomHandle, this.courseHandle, this.retMemberLimit, this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "EnrollUserInCourse.Request{" + "classroomHandle: " + classroomHandle + ", courseHandle: " + courseHandle + ", retMemberLimit: " + retMemberLimit + ", body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static ClassroomHandleStage builder() {
      return new Builder();
    }

    public interface ClassroomHandleStage {
      CourseHandleStage classroomHandle(String classroomHandle);

      Builder from(Request other);
    }

    public interface CourseHandleStage {
      BodyStage courseHandle(String courseHandle);
    }

    public interface BodyStage {
      _FinalStage body(EnrollUserInCourseRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage retMemberLimit(Optional<Double> retMemberLimit);

      _FinalStage retMemberLimit(Double retMemberLimit);

      _FinalStage authOverride(Optional<BasicAuth> authOverride);

      _FinalStage authOverride(BasicAuth authOverride);
    }

    public static final class Builder implements ClassroomHandleStage, CourseHandleStage, BodyStage, _FinalStage {
      private String classroomHandle;

      private String courseHandle;

      private EnrollUserInCourseRequest body;

      private Optional<BasicAuth> authOverride = Optional.empty();

      private Optional<Double> retMemberLimit = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        classroomHandle(other.getClassroomHandle());
        courseHandle(other.getCourseHandle());
        retMemberLimit(other.getRetMemberLimit());
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The classroom's <code>_id</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public CourseHandleStage classroomHandle(String classroomHandle) {
        this.classroomHandle = classroomHandle;
        return this;
      }

      /**
       * <p>The course's <code>_id</code>.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public BodyStage courseHandle(String courseHandle) {
        this.courseHandle = courseHandle;
        return this;
      }

      @Override
      public _FinalStage body(EnrollUserInCourseRequest body) {
        this.body = body;
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
       * <p>limit the return number of members for the classroom, the default value is 1000</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage retMemberLimit(Double retMemberLimit) {
        this.retMemberLimit = Optional.of(retMemberLimit);
        return this;
      }

      @Override
      public _FinalStage retMemberLimit(Optional<Double> retMemberLimit) {
        this.retMemberLimit = retMemberLimit;
        return this;
      }

      @Override
      public Request build() {
        return new Request(classroomHandle, courseHandle, retMemberLimit, body, authOverride);
      }
    }
  }
}
