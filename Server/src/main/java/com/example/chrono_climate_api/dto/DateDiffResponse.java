package com.example.chrono_climate_api.dto;


public class DateDiffResponse {

    private long days;

    public DateDiffResponse(long days) {
        this.days = days;
    }

    public long getDays() {
        return days;
    }
}
