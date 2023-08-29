package com.codecombat.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UsersCreateRequestRole {
    STUDENT("student"),

    TEACHER("teacher");

    private final String value;

    UsersCreateRequestRole(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
