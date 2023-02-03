package com.codecombat.api.client.auth;

import com.codecombat.api.client.auth.exceptions.GetException;
import com.codecombat.api.core.BasicAuth;
import com.codecombat.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/auth/login-o-auth")
interface authService {
  @GET
  @Path("")
  void get(@HeaderParam("Authorization") BasicAuth auth, @QueryParam("provider") String provider,
      @QueryParam("accessToken") Optional<String> accessToken,
      @QueryParam("code") Optional<String> code, @QueryParam("redirect") Optional<String> redirect,
      @QueryParam("errorRedirect") Optional<String> errorRedirect) throws GetException;

  static authService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new authServiceErrorDecoder()).target(authService.class, url);
  }
}
