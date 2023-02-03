package com.codecombat.api.client.clans;

import com.codecombat.api.client.clans.exceptions.UpsertClanException;
import com.codecombat.api.client.clans.types.ClanResponse;
import com.codecombat.api.client.clans.types.UpsertClanRequest;
import com.codecombat.api.core.BasicAuth;
import com.codecombat.api.core.ObjectMappers;
import com.fern.java.jersey.contracts.OptionalAwareContract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/clan/{handle}/members")
interface clansService {
  @PUT
  @Path("")
  ClanResponse upsertClan(@HeaderParam("Authorization") BasicAuth auth, UpsertClanRequest body)
      throws UpsertClanException;

  static clansService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new clansServiceErrorDecoder()).target(clansService.class, url);
  }
}
