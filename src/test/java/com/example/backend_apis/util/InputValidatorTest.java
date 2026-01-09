package com.example.backend_apis.util;

import com.example.backend_apis.exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class InputValidatorTest {


    @Test
    void validDate_shouldPass() {
        assertDoesNotThrow(() -> InputValidator.validateDate("2024-12-31"));
    }




    @Test
    void invalidDate_shouldThrowException() {
        assertThrows(InvalidInputException.class, () ->InputValidator.validateDate("31-12-2024"));
    }





    @Test
    void validNumber_shouldPass() {
        assertDoesNotThrow(() ->InputValidator.validateNumber("999.99"));
    }




    @Test
    void invalidNumber_shouldThrowException() {
        assertThrows(InvalidInputException.class, () ->InputValidator.validateNumber("1000.00"));
    }
}
