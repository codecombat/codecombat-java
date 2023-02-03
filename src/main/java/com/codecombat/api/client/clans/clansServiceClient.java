package com.codecombat.api.client.clans;

import com.codecombat.api.client.clans.endpoints.UpsertClan;
import com.codecombat.api.client.clans.exceptions.UpsertClanException;
import com.codecombat.api.client.clans.types.ClanResponse;
import com.codecombat.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class clansServiceClient {
  private final clansService service;

  private final Optional<BasicAuth> auth;

  public clansServiceClient(String url) {
    this.service = clansService.getClient(url);
    this.auth = Optional.empty();
  }

  public clansServiceClient(String url, BasicAuth auth) {
    this.service = clansService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>Upserts a user into the clan.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpsertClanException Exception that wraps all possible endpoint errors 
   * @return ClanResponse
   */
  public ClanResponse upsertClan(UpsertClan.Request request) throws UpsertClanException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.upsertClan(authValue, request.getBody());
  }
}
