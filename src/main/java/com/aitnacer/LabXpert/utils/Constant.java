package com.aitnacer.LabXpert.utils;

public class Constant {
    public final static String BASE_API_URL = "/api/v1/";
    public final static String ISSUER = "springBootApp";
    public final static String SECRET_KEY = "myPrivetKey@250";
    public final static String BEARER_PREFIX = "Bearer ";
    public final static long EXPIRE_ACCESS_TOKEN = 10*60*1000;//10 min to millis
    public final static long EXPIRE_REFRESH_TOKEN = 120*60*1000;//2 hours
    public static final String AUTH_HEADER = "Authorization";
}
