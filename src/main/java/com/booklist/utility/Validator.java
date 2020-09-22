package com.booklist.utility;

import com.booklist.validation_exception.ValidationException;

public class Validator {

    public static boolean withinRange(String str, String inputItem, int minLength, int maxLength) throws ValidationException {
        if (!StringUtils.checkLengthRange(str, minLength, maxLength)) {
            throw new ValidationException(inputItem + " should be within " + minLength
                    + " and " + maxLength + " characters");
        }
        return true;
    }

    public static boolean validateRequiredItem(String str, String inputItem) throws ValidationException {
        if (StringUtils.isEmpty(str)) {
            throw new ValidationException(inputItem + " is required");
        }
        return true;
    }

    public static boolean validateLoginName(String loginName) throws ValidationException {
        if (!validateRequiredItem(loginName, "Login Id")) {
            return false;
        }
        return withinRange(loginName, "Login Id", 3, 10);
    }

    public static boolean validatePassword(String password) throws ValidationException {
        if (!validateRequiredItem(password, "Password")) {
            return false;
        }
        return withinRange(password, "Password", 3, 10);
    }

    public static boolean validateTitle(String title) throws ValidationException {
        if (!validateRequiredItem(title, "Title")) {
            return false;
        }
        return withinRange(title, "Title", 1, 150);
    }

    public static boolean validateAuthor(String author) throws ValidationException {
        if (!validateRequiredItem(author, "Author")) {
            return false;
        }
        return withinRange(author, "Author", 1, 150);
    }

    public static boolean isNumeric(String str, String inputItem) throws ValidationException {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new ValidationException(inputItem + " should be numeric");
        }
        return true;
    }

}
