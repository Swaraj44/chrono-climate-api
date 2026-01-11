package com.example.chrono_climate_api.service;

import org.springframework.stereotype.Service;


@Service
public class NumberToWordsService {


    private static final String[] BELOW_TWENTY = {
        "zero","one","two","three","four","five","six","seven","eight","nine", "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
    };


    private static final String[] TENS = {
      "", "", "twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"
    };



    public String convert(String input) {

        String[] parts = input.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);

        StringBuilder result = new StringBuilder();
        result.append(convertInt(integerPart));


        if (parts.length == 2) {
            result.append(" point");

            for (char c : parts[1].toCharArray()) {
                result.append(" ").append(BELOW_TWENTY[c - '0']);
            }
        }


        return result.toString().trim();
    }


    
    private String convertInt(int number) {

        if (number < 20) {
            return BELOW_TWENTY[number];
        }

        if (number < 100) {
            int tens = number / 10;
            int rest = number % 10;
            
            return rest == 0 ? TENS[tens] : TENS[tens] + " " + BELOW_TWENTY[rest];
        }


        int hundreds = number / 100;
        int remainder = number % 100;

        if (remainder == 0) {
            return BELOW_TWENTY[hundreds] + " hundred";
        }


        return BELOW_TWENTY[hundreds] + " hundred " + convertInt(remainder);
    }
}
