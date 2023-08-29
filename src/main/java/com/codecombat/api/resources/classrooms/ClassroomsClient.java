package com.codecombat.api.resources.classrooms;

import com.codecombat.api.core.ApiError;
import com.codecombat.api.core.ClientOptions;
import com.codecombat.api.core.ObjectMappers;
import com.codecombat.api.core.RequestOptions;
import com.codecombat.api.resources.classrooms.requests.ClassroomsCreateRequest;
import com.codecombat.api.resources.classrooms.requests.ClassroomsEnrollUserInCourseRequest;
import com.codecombat.api.resources.classrooms.requests.ClassroomsGetMembersStatsRequest;
import com.codecombat.api.resources.classrooms.requests.ClassroomsGetRequest;
import com.codecombat.api.resources.classrooms.requests.ClassroomsRemoveEnrolledUserRequest;
import com.codecombat.api.resources.classrooms.requests.ClassroomsRemoveMemberRequest;
import com.codecombat.api.resources.classrooms.requests.ClassroomsUpsertMemberRequest;
import com.codecombat.api.types.ClassroomResponse;
import com.codecombat.api.types.ClassroomResponseWithCode;
import com.codecombat.api.types.ClassroomsGetMembersStatsResponseItem;
import com.codecombat.api.types.LevelSessionResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ClassroomsClient {
    protected final ClientOptions clientOptions;

    public ClassroomsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ClassroomResponseWithCode get(ClassroomsGetRequest request) {
        return get(request, null);
    }

    public ClassroomResponseWithCode get(ClassroomsGetRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms");
        _httpUrl.addQueryParameter("code", request.getCode());
        if (request.getRetMemberLimit().isPresent()) {
            _httpUrl.addQueryParameter(
                    "retMemberLimit", request.getRetMemberLimit().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClassroomResponseWithCode.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassroomResponseWithCode create(ClassroomsCreateRequest request) {
        return create(request, null);
    }

    public ClassroomResponseWithCode create(ClassroomsCreateRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("name", request.getName());
        _requestBodyProperties.put("ownerID", request.getOwnerId());
        _requestBodyProperties.put("aceConfig", request.getAceConfig());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClassroomResponseWithCode.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassroomResponse upsertMember(String handle, ClassroomsUpsertMemberRequest request) {
        return upsertMember(handle, request, null);
    }

    public ClassroomResponse upsertMember(
            String handle, ClassroomsUpsertMemberRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .addPathSegment(handle)
                .addPathSegments("members")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("code", request.getCode());
        _requestBodyProperties.put("userId", request.getUserId());
        if (request.getRetMemberLimit().isPresent()) {
            _requestBodyProperties.put("retMemberLimit", request.getRetMemberLimit());
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
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClassroomResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassroomResponse removeMember(String handle, ClassroomsRemoveMemberRequest request) {
        return removeMember(handle, request, null);
    }

    public ClassroomResponse removeMember(
            String handle, ClassroomsRemoveMemberRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .addPathSegment(handle)
                .addPathSegments("members")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("userId", request.getUserId());
        if (request.getRetMemberLimit().isPresent()) {
            _requestBodyProperties.put("retMemberLimit", request.getRetMemberLimit());
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
                .method("DELETE", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClassroomResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassroomResponse enrollUserInCourse(
            String classroomHandle, String courseHandle, ClassroomsEnrollUserInCourseRequest request) {
        return enrollUserInCourse(classroomHandle, courseHandle, request, null);
    }

    public ClassroomResponse enrollUserInCourse(
            String classroomHandle,
            String courseHandle,
            ClassroomsEnrollUserInCourseRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .addPathSegment(classroomHandle)
                .addPathSegments("courses")
                .addPathSegment(courseHandle)
                .addPathSegments("enrolled");
        if (request.getRetMemberLimit().isPresent()) {
            _httpUrl.addQueryParameter(
                    "retMemberLimit", request.getRetMemberLimit().get().toString());
        }
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
                .url(_httpUrl.build())
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClassroomResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassroomResponse removeEnrolledUser(
            String classroomHandle, String courseHandle, ClassroomsRemoveEnrolledUserRequest request) {
        return removeEnrolledUser(classroomHandle, courseHandle, request, null);
    }

    public ClassroomResponse removeEnrolledUser(
            String classroomHandle,
            String courseHandle,
            ClassroomsRemoveEnrolledUserRequest request,
            RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .addPathSegment(classroomHandle)
                .addPathSegments("courses")
                .addPathSegment(courseHandle)
                .addPathSegments("remove-enrolled");
        if (request.getRetMemberLimit().isPresent()) {
            _httpUrl.addQueryParameter(
                    "retMemberLimit", request.getRetMemberLimit().get().toString());
        }
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
                .url(_httpUrl.build())
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), ClassroomResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClassroomsGetMembersStatsResponseItem> getMembersStats(
            String classroomHandle, ClassroomsGetMembersStatsRequest request) {
        return getMembersStats(classroomHandle, request, null);
    }

    public List<ClassroomsGetMembersStatsResponseItem> getMembersStats(
            String classroomHandle, ClassroomsGetMembersStatsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .addPathSegment(classroomHandle)
                .addPathSegments("stats");
        if (request.getProject().isPresent()) {
            _httpUrl.addQueryParameter("project", request.getProject().get());
        }
        if (request.getMemberLimit().isPresent()) {
            _httpUrl.addQueryParameter(
                    "memberLimit", request.getMemberLimit().get().toString());
        }
        if (request.getMemberSkip().isPresent()) {
            _httpUrl.addQueryParameter(
                    "memberSkip", request.getMemberSkip().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<ClassroomsGetMembersStatsResponseItem>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClassroomsGetMembersStatsResponseItem> getMembersStats(String classroomHandle) {
        return getMembersStats(
                classroomHandle, ClassroomsGetMembersStatsRequest.builder().build());
    }

    public List<LevelSessionResponse> getLevelsPlayed(String classroomHandle, String memberHandle) {
        return getLevelsPlayed(classroomHandle, memberHandle, null);
    }

    public List<LevelSessionResponse> getLevelsPlayed(
            String classroomHandle, String memberHandle, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("classrooms")
                .addPathSegment(classroomHandle)
                .addPathSegments("members")
                .addPathSegment(memberHandle)
                .addPathSegments("sessions")
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<LevelSessionResponse>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
