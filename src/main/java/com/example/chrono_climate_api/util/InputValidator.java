package com.example.chrono_climate_api.util;

import com.example.chrono_climate_api.exception.InvalidInputException;

public final class InputValidator {

    private InputValidator() {}

    public static void validateDate(String date) {
        if (date == null || !date.matches(ValidationRegex.DATE)) {
            throw new InvalidInputException(
                    "Invalid date format. Expected YYYY-MM-DD"
            );
        }
    }

    public static void validateNumber(String number) {
        if (number == null || !number.matches(ValidationRegex.NUMBER)) {
            throw new InvalidInputException(
                    "Invalid number. Must be < 1000 with max 2 decimals"
            );
        }
    }
}
