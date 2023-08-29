package com.codecombat.api.resources.stats;

import com.codecombat.api.core.ApiError;
import com.codecombat.api.core.ClientOptions;
import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.core.RequestOptions;
import com.codecombat.api.resources.stats.requests.StatsGetPlaytimeStatsRequest;
import com.codecombat.api.types.LicenseStatsResponse;
import com.codecombat.api.types.PlaytimeStatsResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StatsClient {
    protected final ClientOptions clientOptions;

    public StatsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public PlaytimeStatsResponse getPlaytimeStats(StatsGetPlaytimeStatsRequest request) {
        return getPlaytimeStats(request, null);
    }

    public PlaytimeStatsResponse getPlaytimeStats(StatsGetPlaytimeStatsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("playtime-stats");
        if (request.getStartDate().isPresent()) {
            _httpUrl.addQueryParameter("startDate", request.getStartDate().get());
        }
        if (request.getEndDate().isPresent()) {
            _httpUrl.addQueryParameter("endDate", request.getEndDate().get());
        }
        if (request.getCountry().isPresent()) {
            _httpUrl.addQueryParameter("country", request.getCountry().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), PlaytimeStatsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PlaytimeStatsResponse getPlaytimeStats() {
        return getPlaytimeStats(StatsGetPlaytimeStatsRequest.builder().build());
    }

    public LicenseStatsResponse getLicenseStats() {
        return getLicenseStats(null);
    }

    public LicenseStatsResponse getLicenseStats(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("license-stats")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LicenseStatsResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
