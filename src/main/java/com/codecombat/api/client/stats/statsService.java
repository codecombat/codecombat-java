package com.codecombat.api.client.stats;

import com.codecombat.api.client.stats.exceptions.GetLicenseStatsException;
import com.codecombat.api.client.stats.exceptions.GetPlaytimeStatsException;
import com.codecombat.api.client.stats.types.LicenseStatsResponse;
import com.codecombat.api.client.stats.types.PlaytimeStatsResponse;
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
@Path("/")
interface statsService {
  @GET
  @Path("/playtime-stats")
  PlaytimeStatsResponse getPlaytimeStats(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("startDate") Optional<String> startDate,
      @QueryParam("endDate") Optional<String> endDate,
      @QueryParam("country") Optional<String> country) throws GetPlaytimeStatsException;

  @GET
  @Path("/license-stats")
  LicenseStatsResponse getLicenseStats(@HeaderParam("Authorization") BasicAuth auth) throws
      GetLicenseStatsException;

  static statsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new statsServiceErrorDecoder()).target(statsService.class, url);
  }
}
