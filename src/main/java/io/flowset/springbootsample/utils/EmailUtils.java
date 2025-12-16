package io.flowset.springbootsample.utils;

import java.util.regex.Pattern;

public class EmailUtils {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return pattern.matcher(email).matches();
    }
}
