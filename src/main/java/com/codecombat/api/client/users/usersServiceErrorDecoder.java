package com.codecombat.api.client.users;

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
import com.codecombat.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class usersServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("create")) {
        return decodeException(response, CreateException.class);
      }
      if (methodKey.contains("get")) {
        return decodeException(response, GetException.class);
      }
      if (methodKey.contains("update")) {
        return decodeException(response, UpdateException.class);
      }
      if (methodKey.contains("getClassrooms")) {
        return decodeException(response, GetClassroomsException.class);
      }
      if (methodKey.contains("getHero")) {
        return decodeException(response, GetHeroException.class);
      }
      if (methodKey.contains("setAceConfig")) {
        return decodeException(response, SetAceConfigException.class);
      }
      if (methodKey.contains("addOAuthIdentity")) {
        return decodeException(response, AddOAuthIdentityException.class);
      }
      if (methodKey.contains("updateSubscription")) {
        return decodeException(response, UpdateSubscriptionException.class);
      }
      if (methodKey.contains("shortenSubscription")) {
        return decodeException(response, ShortenSubscriptionException.class);
      }
      if (methodKey.contains("grantLicense")) {
        return decodeException(response, GrantLicenseException.class);
      }
      if (methodKey.contains("shortenLicense")) {
        return decodeException(response, ShortenLicenseException.class);
      }
      if (methodKey.contains("findUser")) {
        return decodeException(response, FindUserException.class);
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
