package com.yfy.beem.serverv2.util;

/**
 * Class that holds mappings for REST endpoints.
 * */
public final class Mappings {
    // do not let anyone instantiate this class
    private Mappings() {
        throw new UnsupportedOperationException("dude what are you doing");
    }

    public static final String API_ROOT = "api";
    public static final String GET_USERS = "users";
    public static final String ADD_USER = "users";
}
