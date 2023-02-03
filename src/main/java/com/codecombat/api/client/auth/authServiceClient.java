package com.codecombat.api.client.auth;

import com.codecombat.api.client.auth.endpoints.Get;
import com.codecombat.api.client.auth.exceptions.GetException;
import com.codecombat.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class authServiceClient {
  private final authService service;

  private final Optional<BasicAuth> auth;

  public authServiceClient(String url) {
    this.service = authService.getClient(url);
    this.auth = Optional.empty();
  }

  public authServiceClient(String url, BasicAuth auth) {
    this.service = authService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>Logs a <a href="#users">user</a> in. #### Example <code>javascript url = `https://codecombat.com/auth/login-o-auth?provider=${OAUTH_PROVIDER_ID}&amp;accessToken=1234` res.redirect(url) // User is sent to this CodeCombat URL and assuming everything checks out, // is logged in and redirected to the home page.</code> In this example, we call your lookup URL (let's say, <code>https://oauth.provider/user?t=&lt;%= accessToken %&gt;</code>) with the access token (<code>1234</code>). The lookup URL returns <code>{ id: 'abcd' }</code> in this case. We will match this <code>id</code> with the OAuthIdentity stored in the user information in our db. If everything checks out, the user is logged in and redirected to the home page.</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetException Exception that wraps all possible endpoint errors 
   */
  public void get(Get.Request request) throws GetException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.get(authValue, request.getProvider(), request.getAccessToken(), request.getCode(), request.getRedirect(), request.getErrorRedirect());
  }
}
