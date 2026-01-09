package com.example.backend_apis.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class DateDifferenceServiceTest {

    private final com.example.backend_apis.service.DateCalculationService service =
            new com.example.backend_apis.service.DateCalculationService();



    @Test
    void sameDate_shouldReturnZero() {
        assertEquals(0,service.calculateDaysBetween("2026-01-01", "2026-01-01"));
    }




    @Test
    void consecutiveDates() {
        assertEquals(1,service.calculateDaysBetween("2026-01-01", "2026-01-02"));
    }




    @Test
    void crossMonthCalculation() {
        assertEquals(30,service.calculateDaysBetween("2026-01-01", "2026-01-31"));
    }
}
