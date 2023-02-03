package com.codecombat.api.client.classrooms;

import com.codecombat.api.client.classrooms.endpoints.Create;
import com.codecombat.api.client.classrooms.endpoints.DeleteUserFromClassroom;
import com.codecombat.api.client.classrooms.endpoints.EnrollUserInCourse;
import com.codecombat.api.client.classrooms.endpoints.Get;
import com.codecombat.api.client.classrooms.endpoints.GetLevelSession;
import com.codecombat.api.client.classrooms.endpoints.GetMembersStats;
import com.codecombat.api.client.classrooms.endpoints.RemoveUserFromClassroom;
import com.codecombat.api.client.classrooms.endpoints.UpsertFromClassroom;
import com.codecombat.api.client.classrooms.exceptions.CreateException;
import com.codecombat.api.client.classrooms.exceptions.DeleteUserFromClassroomException;
import com.codecombat.api.client.classrooms.exceptions.EnrollUserInCourseException;
import com.codecombat.api.client.classrooms.exceptions.GetException;
import com.codecombat.api.client.classrooms.exceptions.GetLevelSessionException;
import com.codecombat.api.client.classrooms.exceptions.GetMembersStatsException;
import com.codecombat.api.client.classrooms.exceptions.RemoveUserFromClassroomException;
import com.codecombat.api.client.classrooms.exceptions.UpsertFromClassroomException;
import com.codecombat.api.client.classrooms.types.LevelSessionResponse;
import com.codecombat.api.client.classrooms.types.MemberStat;
import com.codecombat.api.client.commons.types.ClassroomResponse;
import com.codecombat.api.client.commons.types.ClassroomResponseWithCode;
import com.codecombat.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public final class classroomsServiceClient {
  private final classroomsService service;

  private final Optional<BasicAuth> auth;

  public classroomsServiceClient(String url) {
    this.service = classroomsService.getClient(url);
    this.auth = Optional.empty();
  }

  public classroomsServiceClient(String url, BasicAuth auth) {
    this.service = classroomsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>Returns the classroom details for a class code.</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetException Exception that wraps all possible endpoint errors 
   * @return ClassroomResponseWithCode
   */
  public ClassroomResponseWithCode get(Get.Request request) throws GetException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.get(authValue, request.getCode(), request.getRetMemberLimit());
  }

  /**
   * <p>Creates a new empty <code>Classroom</code>.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws CreateException Exception that wraps all possible endpoint errors 
   */
  public void create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.create(authValue, request.getBody());
  }

  /**
   * <p>Upserts a user into the classroom.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpsertFromClassroomException Exception that wraps all possible endpoint errors 
   * @return ClassroomResponse
   */
  public ClassroomResponse upsertFromClassroom(UpsertFromClassroom.Request request) throws
      UpsertFromClassroomException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.upsertFromClassroom(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Remove a user from the classroom.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws DeleteUserFromClassroomException Exception that wraps all possible endpoint errors 
   * @return ClassroomResponse
   */
  public ClassroomResponse deleteUserFromClassroom(DeleteUserFromClassroom.Request request) throws
      DeleteUserFromClassroomException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.deleteUserFromClassroom(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Enrolls a user in a course in a classroom.
   * If the course is paid, user must have an active license.
   * User must be a member of the classroom.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws EnrollUserInCourseException Exception that wraps all possible endpoint errors 
   * @return ClassroomResponse
   */
  public ClassroomResponse enrollUserInCourse(EnrollUserInCourse.Request request) throws
      EnrollUserInCourseException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.enrollUserInCourse(authValue, request.getClassroomHandle(), request.getCourseHandle(), request.getRetMemberLimit(), request.getBody());
  }

  /**
   * <p>Removes an enrolled user from a course in a classroom.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws RemoveUserFromClassroomException Exception that wraps all possible endpoint errors 
   * @return ClassroomResponse
   */
  public ClassroomResponse removeUserFromClassroom(RemoveUserFromClassroom.Request request) throws
      RemoveUserFromClassroomException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.removeUserFromClassroom(authValue, request.getClassroomHandle(), request.getCourseHandle(), request.getRetMemberLimit(), request.getBody());
  }

  /**
   * <p>Returns a list of all members stats for the classroom.</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetMembersStatsException Exception that wraps all possible endpoint errors 
   * @return List<MemberStat>
   */
  public List<MemberStat> getMembersStats(GetMembersStats.Request request) throws
      GetMembersStatsException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getMembersStats(authValue, request.getClassroomHandle(), request.getProject(), request.getMemberLimit(), request.getMemberSkip());
  }

  /**
   * <p>Returns a list of all levels played by the user for the classroom.</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetLevelSessionException Exception that wraps all possible endpoint errors 
   * @return List<LevelSessionResponse>
   */
  public List<LevelSessionResponse> getLevelSession(GetLevelSession.Request request) throws
      GetLevelSessionException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getLevelSession(authValue, request.getClassroomHandle(), request.getMemberHandle());
  }
}
