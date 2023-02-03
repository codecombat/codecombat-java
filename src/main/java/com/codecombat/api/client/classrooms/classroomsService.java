package com.codecombat.api.client.classrooms;

import com.codecombat.api.client.classrooms.exceptions.CreateException;
import com.codecombat.api.client.classrooms.exceptions.DeleteUserFromClassroomException;
import com.codecombat.api.client.classrooms.exceptions.EnrollUserInCourseException;
import com.codecombat.api.client.classrooms.exceptions.GetException;
import com.codecombat.api.client.classrooms.exceptions.GetLevelSessionException;
import com.codecombat.api.client.classrooms.exceptions.GetMembersStatsException;
import com.codecombat.api.client.classrooms.exceptions.RemoveUserFromClassroomException;
import com.codecombat.api.client.classrooms.exceptions.UpsertFromClassroomException;
import com.codecombat.api.client.classrooms.types.CreateClassroomRequest;
import com.codecombat.api.client.classrooms.types.DeleteUserFromClassroomRequest;
import com.codecombat.api.client.classrooms.types.EnrollUserInCourseRequest;
import com.codecombat.api.client.classrooms.types.LevelSessionResponse;
import com.codecombat.api.client.classrooms.types.MemberStat;
import com.codecombat.api.client.classrooms.types.RemoveUserFromClassroomRequest;
import com.codecombat.api.client.classrooms.types.UpsertClassroomRequest;
import com.codecombat.api.client.commons.types.ClassroomResponse;
import com.codecombat.api.client.commons.types.ClassroomResponseWithCode;
import com.codecombat.api.core.BasicAuth;
import com.codecombat.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Double;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/classrooms")
interface classroomsService {
  @GET
  @Path("")
  ClassroomResponseWithCode get(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("code") String code,
      @QueryParam("retMemberLimit") Optional<Double> retMemberLimit) throws GetException;

  @POST
  @Path("")
  void create(@HeaderParam("Authorization") BasicAuth auth, CreateClassroomRequest body) throws
      CreateException;

  @PUT
  @Path("/{handle}/members")
  ClassroomResponse upsertFromClassroom(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, UpsertClassroomRequest body) throws
      UpsertFromClassroomException;

  @DELETE
  @Path("/{handle}/members")
  ClassroomResponse deleteUserFromClassroom(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, DeleteUserFromClassroomRequest body) throws
      DeleteUserFromClassroomException;

  @PUT
  @Path("/{classroomHandle}/courses/{courseHandle}/enrolled")
  ClassroomResponse enrollUserInCourse(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("classroomHandle") String classroomHandle,
      @PathParam("courseHandle") String courseHandle,
      @QueryParam("retMemberLimit") Optional<Double> retMemberLimit, EnrollUserInCourseRequest body)
      throws EnrollUserInCourseException;

  @PUT
  @Path("/{classroomHandle}/courses/{courseHandle}/remove-enrolled")
  ClassroomResponse removeUserFromClassroom(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("classroomHandle") String classroomHandle,
      @PathParam("courseHandle") String courseHandle,
      @QueryParam("retMemberLimit") Optional<Double> retMemberLimit,
      RemoveUserFromClassroomRequest body) throws RemoveUserFromClassroomException;

  @GET
  @Path("/{classroomHandle}/stats")
  List<MemberStat> getMembersStats(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("classroomHandle") String classroomHandle,
      @QueryParam("project") Optional<String> project,
      @QueryParam("memberLimit") Optional<Double> memberLimit,
      @QueryParam("memberSkip") Optional<Double> memberSkip) throws GetMembersStatsException;

  @GET
  @Path("/{classroomHandle}/members/{memberHandle}/sessions")
  List<LevelSessionResponse> getLevelSession(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("classroomHandle") String classroomHandle,
      @PathParam("memberHandle") String memberHandle) throws GetLevelSessionException;

  static classroomsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new classroomsServiceErrorDecoder()).target(classroomsService.class, url);
  }
}
