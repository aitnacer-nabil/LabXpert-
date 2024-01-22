package com.aitnacer.LabXpert.utils;

public class Utils {
    public static boolean isStringValid(String value, int minLength) {
        return value != null && !value.isEmpty() && value.length() >= minLength;
    }
}
