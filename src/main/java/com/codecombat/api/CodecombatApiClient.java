package com.codecombat.api;

import com.codecombat.api.core.ApiError;
import com.codecombat.api.core.ClientOptions;
import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.core.RequestOptions;
import com.codecombat.api.core.Suppliers;
import com.codecombat.api.requests.PostUsersHandleOAuthIdentitiesRequest;
import com.codecombat.api.resources.auth.AuthClient;
import com.codecombat.api.resources.clans.ClansClient;
import com.codecombat.api.resources.classrooms.ClassroomsClient;
import com.codecombat.api.resources.stats.StatsClient;
import com.codecombat.api.resources.users.UsersClient;
import com.codecombat.api.types.UserResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CodecombatApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AuthClient> authClient;

    protected final Supplier<ClansClient> clansClient;

    protected final Supplier<ClassroomsClient> classroomsClient;

    protected final Supplier<StatsClient> statsClient;

    protected final Supplier<UsersClient> usersClient;

    public CodecombatApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.authClient = Suppliers.memoize(() -> new AuthClient(clientOptions));
        this.clansClient = Suppliers.memoize(() -> new ClansClient(clientOptions));
        this.classroomsClient = Suppliers.memoize(() -> new ClassroomsClient(clientOptions));
        this.statsClient = Suppliers.memoize(() -> new StatsClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
    }

    public UserResponse postUsersHandleOAuthIdentities(String handle, PostUsersHandleOAuthIdentitiesRequest request) {
        return postUsersHandleOAuthIdentities(handle, request, null);
    }

    public UserResponse postUsersHandleOAuthIdentities(
            String handle, PostUsersHandleOAuthIdentitiesRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("users")
                .addPathSegment(handle)
                .addPathSegments("o-auth-identities")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("provider", request.getProvider());
        if (request.getAccessToken().isPresent()) {
            _requestBodyProperties.put("accessToken", request.getAccessToken());
        }
        if (request.getCode().isPresent()) {
            _requestBodyProperties.put("code", request.getCode());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), UserResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AuthClient auth() {
        return this.authClient.get();
    }

    public ClansClient clans() {
        return this.clansClient.get();
    }

    public ClassroomsClient classrooms() {
        return this.classroomsClient.get();
    }

    public StatsClient stats() {
        return this.statsClient.get();
    }

    public UsersClient users() {
        return this.usersClient.get();
    }

    public static CodecombatApiClientBuilder builder() {
        return new CodecombatApiClientBuilder();
    }
}
