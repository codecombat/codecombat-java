package com.codecombat.api.resources.auth;

import com.codecombat.api.core.ApiError;
import com.codecombat.api.core.ClientOptions;
import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.core.RequestOptions;
import com.codecombat.api.resources.auth.requests.LoginOauthRequest;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthClient {
    protected final ClientOptions clientOptions;

    public AuthClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public void loginOauth(LoginOauthRequest request) {
        loginOauth(request, null);
    }

    public void loginOauth(LoginOauthRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/login-o-auth");
        _httpUrl.addQueryParameter("provider", request.getProvider());
        if (request.getAccessToken().isPresent()) {
            _httpUrl.addQueryParameter("accessToken", request.getAccessToken().get());
        }
        if (request.getCode().isPresent()) {
            _httpUrl.addQueryParameter("code", request.getCode().get());
        }
        if (request.getRedirect().isPresent()) {
            _httpUrl.addQueryParameter("redirect", request.getRedirect().get());
        }
        if (request.getErrorRedirect().isPresent()) {
            _httpUrl.addQueryParameter(
                    "errorRedirect", request.getErrorRedirect().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
