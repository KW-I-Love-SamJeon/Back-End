package com.IULP.BackEnd.Common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("Role_User"),
    ADMIN("Role_Admin");

    private final String value;
}
