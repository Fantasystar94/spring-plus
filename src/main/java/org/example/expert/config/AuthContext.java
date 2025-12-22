package org.example.expert.config;

import org.example.expert.domain.common.dto.AuthUser;

public class AuthContext {
    public static final ThreadLocal<AuthUser> AUTH_USER = new ThreadLocal<>();

    public static void set(AuthUser authUser) {
        AUTH_USER.set(authUser);
    }
    public static AuthUser get() {
        return AUTH_USER.get();
    }
    public static void clear() {
        AUTH_USER.remove();
    }
}