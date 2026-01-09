package com.example.backend_apis.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class NumberToWordsServiceTest {

    private final NumberToWordsService service = new NumberToWordsService();

    @Test
    void integerConversion() {
        assertEquals("thirty six", service.convert("36"));
    }



    @Test
    void hundredConversion() {
        assertEquals("one hundred five", service.convert("105"));
    }




    @Test
    void decimalConversion() {
        assertEquals("thirty six point four zero",service.convert("36.40"));
    }



    @Test
    void zeroConversion() {
        assertEquals("zero", service.convert("0"));
    }
}
