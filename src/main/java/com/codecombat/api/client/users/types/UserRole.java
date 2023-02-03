package com.codecombat.api.client.users.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class UserRole {
  public static final UserRole TEACHER = new UserRole(Value.TEACHER, "teacher");

  public static final UserRole STUDENT = new UserRole(Value.STUDENT, "student");

  private final Value value;

  private final String string;

  UserRole(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof UserRole && this.string.equals(((UserRole) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case TEACHER:
        return visitor.visitTeacher();
      case STUDENT:
        return visitor.visitStudent();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static UserRole valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "teacher":
        return TEACHER;
      case "student":
        return STUDENT;
      default:
        return new UserRole(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    STUDENT,

    TEACHER,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitStudent();

    T visitTeacher();

    T visitUnknown(String unknownType);
  }
}
