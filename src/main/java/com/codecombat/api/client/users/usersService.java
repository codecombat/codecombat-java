package com.codecombat.api.client.users;

import com.codecombat.api.client.commons.types.ClassroomResponseWithCode;
import com.codecombat.api.client.commons.types.UserResponse;
import com.codecombat.api.client.users.exceptions.AddOAuthIdentityException;
import com.codecombat.api.client.users.exceptions.CreateException;
import com.codecombat.api.client.users.exceptions.FindUserException;
import com.codecombat.api.client.users.exceptions.GetClassroomsException;
import com.codecombat.api.client.users.exceptions.GetException;
import com.codecombat.api.client.users.exceptions.GetHeroException;
import com.codecombat.api.client.users.exceptions.GrantLicenseException;
import com.codecombat.api.client.users.exceptions.SetAceConfigException;
import com.codecombat.api.client.users.exceptions.ShortenLicenseException;
import com.codecombat.api.client.users.exceptions.ShortenSubscriptionException;
import com.codecombat.api.client.users.exceptions.UpdateException;
import com.codecombat.api.client.users.exceptions.UpdateSubscriptionException;
import com.codecombat.api.client.users.types.AddOAuthIdentityRequest;
import com.codecombat.api.client.users.types.CreateUserRequest;
import com.codecombat.api.client.users.types.GetHeroRequest;
import com.codecombat.api.client.users.types.GrantLicenseRequest;
import com.codecombat.api.client.users.types.SetAceConfig;
import com.codecombat.api.client.users.types.ShortenLicenseRequest;
import com.codecombat.api.client.users.types.ShortenSubscriptionRequest;
import com.codecombat.api.client.users.types.UpdateSubscriptionRequest;
import com.codecombat.api.client.users.types.UpdateUserRequest;
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
@Path("/")
interface usersService {
  @POST
  @Path("/users")
  void create(@HeaderParam("Authorization") BasicAuth auth, CreateUserRequest body) throws
      CreateException;

  @GET
  @Path("/users/{handle}")
  UserResponse get(@HeaderParam("Authorization") BasicAuth auth, @PathParam("handle") String handle,
      @QueryParam("includePlayTime") Optional<String> includePlayTime) throws GetException;

  @PUT
  @Path("/users/{handle}")
  UserResponse update(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, UpdateUserRequest body) throws UpdateException;

  @GET
  @Path("/users/{handle}/classrooms")
  List<ClassroomResponseWithCode> getClassrooms(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle,
      @QueryParam("retMemberLimit") Optional<Double> retMemberLimit) throws GetClassroomsException;

  @PUT
  @Path("/users/{handle}/hero-config")
  UserResponse getHero(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, GetHeroRequest body) throws GetHeroException;

  @PUT
  @Path("/users/{handle}/ace-config")
  UserResponse setAceConfig(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, SetAceConfig body) throws SetAceConfigException;

  @POST
  @Path("/users/{handle}/o-auth-identities")
  UserResponse addOAuthIdentity(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, AddOAuthIdentityRequest body) throws
      AddOAuthIdentityException;

  @PUT
  @Path("/users/{handle}/subscription")
  UserResponse updateSubscription(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, UpdateSubscriptionRequest body) throws
      UpdateSubscriptionException;

  @PUT
  @Path("/users/{handle}/shorten-subscription")
  UserResponse shortenSubscription(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, ShortenSubscriptionRequest body) throws
      ShortenSubscriptionException;

  @PUT
  @Path("/users/{handle}/license")
  UserResponse grantLicense(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, GrantLicenseRequest body) throws GrantLicenseException;

  @PUT
  @Path("/users/{handle}/shorten-license")
  UserResponse shortenLicense(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("handle") String handle, ShortenLicenseRequest body) throws
      ShortenLicenseException;

  @GET
  @Path("/user-lookup/{property}/{value}")
  void findUser(@HeaderParam("Authorization") BasicAuth auth,
      @PathParam("property") String property, @PathParam("value") String value) throws
      FindUserException;

  static usersService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new usersServiceErrorDecoder()).target(usersService.class, url);
  }
}
