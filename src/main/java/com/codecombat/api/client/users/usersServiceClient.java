package com.codecombat.api.client.users;

import com.codecombat.api.client.commons.types.ClassroomResponseWithCode;
import com.codecombat.api.client.commons.types.UserResponse;
import com.codecombat.api.client.users.endpoints.AddOAuthIdentity;
import com.codecombat.api.client.users.endpoints.Create;
import com.codecombat.api.client.users.endpoints.FindUser;
import com.codecombat.api.client.users.endpoints.Get;
import com.codecombat.api.client.users.endpoints.GetClassrooms;
import com.codecombat.api.client.users.endpoints.GetHero;
import com.codecombat.api.client.users.endpoints.GrantLicense;
import com.codecombat.api.client.users.endpoints.SetAceConfig;
import com.codecombat.api.client.users.endpoints.ShortenLicense;
import com.codecombat.api.client.users.endpoints.ShortenSubscription;
import com.codecombat.api.client.users.endpoints.Update;
import com.codecombat.api.client.users.endpoints.UpdateSubscription;
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
import com.codecombat.api.core.BasicAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public final class usersServiceClient {
  private final usersService service;

  private final Optional<BasicAuth> auth;

  public usersServiceClient(String url) {
    this.service = usersService.getClient(url);
    this.auth = Optional.empty();
  }

  public usersServiceClient(String url, BasicAuth auth) {
    this.service = usersService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>Creates a <code>User</code>.</p>
   * <h4>Example</h4>
   * <pre><code class="language-javascript">url = 'https://codecombat.com/api/users'
   * json = { email: 'an@email.com', name: 'Some Username', role: 'student' }
   * request.post({ url, json, auth })
   * </code></pre>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws CreateException Exception that wraps all possible endpoint errors 
   */
  public void create(Create.Request request) throws CreateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.create(authValue, request.getBody());
  }

  /**
   * <p>Returns a <code>User</code>.</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse get(Get.Request request) throws GetException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.get(authValue, request.getHandle(), request.getIncludePlayTime());
  }

  /**
   * <p>Modify name of a <code>User</code></p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpdateException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse update(Update.Request request) throws UpdateException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Returns a list of <code>Classrooms</code> this user is in (if a student) or owns (if a teacher).</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws GetClassroomsException Exception that wraps all possible endpoint errors 
   * @return List<ClassroomResponseWithCode>
   */
  public List<ClassroomResponseWithCode> getClassrooms(GetClassrooms.Request request) throws
      GetClassroomsException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getClassrooms(authValue, request.getHandle(), request.getRetMemberLimit());
  }

  /**
   * <p>Set the user's hero.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws GetHeroException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse getHero(GetHero.Request request) throws GetHeroException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.getHero(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Set the user's aceConfig (the settings for the in-game Ace code editor), such as whether to enable autocomplete.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws SetAceConfigException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse setAceConfig(SetAceConfig.Request request) throws SetAceConfigException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.setAceConfig(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Adds an OAuth2 identity to the user, so that they can be logged in with that identity. You need to send the OAuth code or the access token to this endpoint. 1. If no access token is provided, it will use your OAuth2 token URL to exchange the given code for an access token. 1. Then it will use the access token (given by you, or received from step 1) to look up the user on your service using the lookup URL, and expects a JSON object in response with an <code>id</code> property. 1. It will then save that user <code>id</code> to the user in our db as a new OAuthIdentity. #### Example <code>javascript url = `https://codecombat.com/api/users/${userID}/o-auth-identities` OAUTH_PROVIDER_ID = 'xyz' json = { provider: OAUTH_PROVIDER_ID, accessToken: '1234' } request.post({ url, json, auth}, (err, res) =&gt; { console.log(res.body.oAuthIdentities) // [ { provider: 'xyx', id: 'abcd' } ] })</code> In this example, we call your lookup URL (let's say, <code>https://oauth.provider/user?t=&lt;%= accessToken %&gt;</code>) with the access token (<code>1234</code>). The lookup URL returns <code>{ id: 'abcd' }</code> in this case, which we save to the user in our db.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws AddOAuthIdentityException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse addOAuthIdentity(AddOAuthIdentity.Request request) throws
      AddOAuthIdentityException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.addOAuthIdentity(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Grants a user premium access to the &quot;Home&quot; version up to a certain time.</p>
   * <h4>Example</h4>
   * <pre><code class="language-javascript">url = `https://codecombat.com/api/users/${userID}/subscription`
   * json = { ends: new Date('2017-01-01').toISOString() }
   * request.put({ url, json, auth }, (err, res) =&gt; {
   *   console.log(res.body.subscription) // { ends: '2017-01-01T00:00:00.000Z', active: true }
   * })
   * </code></pre>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpdateSubscriptionException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse updateSubscription(UpdateSubscription.Request request) throws
      UpdateSubscriptionException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.updateSubscription(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>If the user already has a premium access up to a certain time, this shortens/revokes his/her premium access. If the ends is less than or equal to the current time, it revokes the subscription and sets the end date to be the current time, else it just shortens the subscription. #### Example <code>javascript url = `https://codecombat.com/api/users/${userID}/shorten-subscription` json = { ends: new Date().toISOString() } request.put({ url, json, auth }, (err, res) =&gt; { console.log(res.body.subscription.active) // false })</code></p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws ShortenSubscriptionException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse shortenSubscription(ShortenSubscription.Request request) throws
      ShortenSubscriptionException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.shortenSubscription(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Grants a user access to the &quot;Classroom&quot; version up to a certain time.
   * Sets their role to &quot;student&quot;.</p>
   * <h4>Example</h4>
   * <pre><code class="language-javascript">url = `https://codecombat.com/api/users/${userID}/license`
   * json = { ends: new Date('2017-01-01').toISOString() }
   * request.put({ url, json, auth }, (err, res) =&gt; {
   *   console.log(res.body.license) // { ends: '2017-01-01T00:00:00.000Z', active: true }
   * })
   * </code></pre>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws GrantLicenseException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse grantLicense(GrantLicense.Request request) throws GrantLicenseException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.grantLicense(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>If the user already has access to the &quot;Classroom&quot; version up to a certain time, this shortens/revokes his/her access. If the ends is less than or equal to the current time, it revokes the enrollment and sets the end date to be the current time, else it just shortens the enrollment. #### Example <code>javascript url = `https://codecombat.com/api/users/${userID}/shorten-license` json = { ends: new Date().toISOString() } request.put({ url, json, auth }, (err, res) =&gt; { console.log(res.body.license.active) // false })</code></p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws ShortenLicenseException Exception that wraps all possible endpoint errors 
   * @return UserResponse
   */
  public UserResponse shortenLicense(ShortenLicense.Request request) throws
      ShortenLicenseException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.shortenLicense(authValue, request.getHandle(), request.getBody());
  }

  /**
   * <p>Redirects to <code>/users/{handle}</code> given a unique, identifying property</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws FindUserException Exception that wraps all possible endpoint errors 
   */
  public void findUser(FindUser.Request request) throws FindUserException {
    BasicAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    this.service.findUser(authValue, request.getProperty(), request.getValue());
  }
}
