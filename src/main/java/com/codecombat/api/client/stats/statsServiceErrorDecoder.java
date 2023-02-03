package com.codecombat.api.client.stats;

import com.codecombat.api.client.stats.exceptions.GetLicenseStatsException;
import com.codecombat.api.client.stats.exceptions.GetPlaytimeStatsException;
import com.codecombat.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class statsServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("getPlaytimeStats")) {
        return decodeException(response, GetPlaytimeStatsException.class);
      }
      if (methodKey.contains("getLicenseStats")) {
        return decodeException(response, GetLicenseStatsException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
