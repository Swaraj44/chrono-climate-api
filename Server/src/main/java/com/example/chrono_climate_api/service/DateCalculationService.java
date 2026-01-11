package com.example.chrono_climate_api.service;

import org.springframework.stereotype.Service;


@Service
public class DateCalculationService {


    public long calculateDaysBetween(String startDate, String endDate) {
        long start = toDays(startDate);
        long end = toDays(endDate);
        return Math.abs(end - start);
    }


    
    private long toDays(String date) {                     // total days since 0000-03-01
    String[] parts = date.split("-");

    int year  = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int day   = Integer.parseInt(parts[2]);

    
    if (month < 3) {                                       // january and february shifed to the previous year
        year--;
        month += 12;
    }

    long daysFromYears   = 365L * year;
    long leapYearDays    = year / 4 - year / 100 + year / 400;
    long daysFromMonths  = (153L * (month - 3) + 2) / 5;
    long daysFromCurrent = day - 1;
    

    return daysFromYears + leapYearDays + daysFromMonths + daysFromCurrent;
}

}
