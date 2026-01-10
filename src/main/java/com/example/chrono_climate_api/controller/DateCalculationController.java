package com.example.chrono_climate_api.controller;

import com.example.chrono_climate_api.dto.DateDiffRequest;
import com.example.chrono_climate_api.dto.DateDiffResponse;

import com.example.chrono_climate_api.service.DateCalculationService;
import com.example.chrono_climate_api.util.InputValidator;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class DateCalculationController {

    private final DateCalculationService service;

    public DateCalculationController(DateCalculationService service) {
        this.service = service;
    }


    
    @PostMapping("/number-of-days")
    public DateDiffResponse numberOfDays(@RequestBody DateDiffRequest request) {

    InputValidator.validateDate(request.getStartDate());
    InputValidator.validateDate(request.getEndDate());

    long days = service.calculateDaysBetween(request.getStartDate(),request.getEndDate());

    return new DateDiffResponse(days);
}

}