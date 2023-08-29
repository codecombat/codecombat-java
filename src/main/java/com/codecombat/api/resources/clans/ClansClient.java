package com.codecombat.api.resources.clans;

import com.codecombat.api.core.ApiError;
import com.codecombat.api.core.ClientOptions;
import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.core.RequestOptions;
import com.codecombat.api.resources.clans.requests.ClansUpsertMemberRequest;
import com.codecombat.api.types.ClanResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ClansClient {
    protected final ClientOptions clientOptions;

    public ClansClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ClanResponse upsertMember(String handle, ClansUpsertMemberRequest request) {
        return upsertMember(handle, request, null);
    }

    public ClanResponse upsertMember(String handle, ClansUpsertMemberRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("clan")
                .addPathSegment(handle)
                .addPathSegments("members")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("userId", request.getUserId());
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
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClanResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
