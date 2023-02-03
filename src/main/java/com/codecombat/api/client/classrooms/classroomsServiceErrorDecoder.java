package com.codecombat.api.client.classrooms;

import com.codecombat.api.client.classrooms.exceptions.CreateException;
import com.codecombat.api.client.classrooms.exceptions.DeleteUserFromClassroomException;
import com.codecombat.api.client.classrooms.exceptions.EnrollUserInCourseException;
import com.codecombat.api.client.classrooms.exceptions.GetException;
import com.codecombat.api.client.classrooms.exceptions.GetLevelSessionException;
import com.codecombat.api.client.classrooms.exceptions.GetMembersStatsException;
import com.codecombat.api.client.classrooms.exceptions.RemoveUserFromClassroomException;
import com.codecombat.api.client.classrooms.exceptions.UpsertFromClassroomException;
import com.codecombat.api.core.ObjectMappers;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class classroomsServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("get")) {
        return decodeException(response, GetException.class);
      }
      if (methodKey.contains("create")) {
        return decodeException(response, CreateException.class);
      }
      if (methodKey.contains("upsertFromClassroom")) {
        return decodeException(response, UpsertFromClassroomException.class);
      }
      if (methodKey.contains("deleteUserFromClassroom")) {
        return decodeException(response, DeleteUserFromClassroomException.class);
      }
      if (methodKey.contains("enrollUserInCourse")) {
        return decodeException(response, EnrollUserInCourseException.class);
      }
      if (methodKey.contains("removeUserFromClassroom")) {
        return decodeException(response, RemoveUserFromClassroomException.class);
      }
      if (methodKey.contains("getMembersStats")) {
        return decodeException(response, GetMembersStatsException.class);
      }
      if (methodKey.contains("getLevelSession")) {
        return decodeException(response, GetLevelSessionException.class);
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
