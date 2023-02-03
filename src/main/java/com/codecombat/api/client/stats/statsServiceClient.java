package com.codecombat.api.client.stats;

import com.codecombat.api.client.stats.endpoints.GetLicenseStats;
import com.codecombat.api.client.stats.endpoints.GetPlaytimeStats;
import com.codecombat.api.client.stats.exceptions.GetLicenseStatsException;
import com.codecombat.api.client.stats.exceptions.GetPlaytimeStatsException;
import com.codecombat.api.client.stats.types.LicenseStatsResponse;
import com.codecombat.api.client.stats.types.PlaytimeStatsResponse;
import com.codecombat.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class statsServiceClient {
  private final statsService service;

  private final Optional<BasicAuth> auth;

  public statsServiceClient(String url) {
    this.service = statsService.getClient(url);
    this.auth = Optional.empty();
  }

  public statsServiceClient(String url, BasicAuth auth) {
    this.service = statsService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>Returns the playtime stats</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetPlaytimeStatsException Exception that wraps all possible endpoint errors 
   * @return PlaytimeStatsResponse
   */
  public PlaytimeStatsResponse getPlaytimeStats(GetPlaytimeStats.Request request) throws
      GetPlaytimeStatsException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getPlaytimeStats(authValue, request.getStartDate(), request.getEndDate(), request.getCountry());
  }

  /**
   * <p>Returns the license stats</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetLicenseStatsException Exception that wraps all possible endpoint errors 
   * @return LicenseStatsResponse
   */
  public LicenseStatsResponse getLicenseStats(GetLicenseStats.Request request) throws
      GetLicenseStatsException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getLicenseStats(authValue);
  }
}
