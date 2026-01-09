package com.example.backend_apis.controller;

import com.example.backend_apis.dto.DateDiffRequest;
import com.example.backend_apis.dto.DateDiffResponse;
import com.example.backend_apis.service.DateCalculationService;
import com.example.backend_apis.util.InputValidator;

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

    long days = service.calculateDaysBetween(
            request.getStartDate(),
            request.getEndDate()
    );
    return new DateDiffResponse(days);
}

}
