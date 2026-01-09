package com.example.backend_apis.controller;

import com.example.backend_apis.dto.DateDiffRequest;
import com.example.backend_apis.dto.NumberToWordsRequest;
import com.example.backend_apis.dto.TemperatureStatsRequest;
import com.example.backend_apis.dto.DateDiffResponse;
import com.example.backend_apis.dto.NumberToWordsResponse;
import com.example.backend_apis.dto.TemperatureStatsResponse;
import com.example.backend_apis.service.DateCalculationService;
import com.example.backend_apis.service.NumberToWordsService;
import com.example.backend_apis.service.TemperatureStatsService;
import com.example.backend_apis.util.InputValidator;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/")   // root mapping for tests
public class BackendApiController {

    private final DateCalculationService dateCalculationService;
    private final NumberToWordsService numberToWordsService;
    private final TemperatureStatsService temperatureStatsService;

    public BackendApiController(DateCalculationService dateCalculationService,
                                NumberToWordsService numberToWordsService,
                                TemperatureStatsService temperatureStatsService) {

        this.dateCalculationService = dateCalculationService;
        this.numberToWordsService = numberToWordsService;
        this.temperatureStatsService = temperatureStatsService;
    }



 
    @PostMapping("/number-of-days")
    public DateDiffResponse numberOfDays(@RequestBody DateDiffRequest request) {

        InputValidator.validateDate(request.getStartDate());
        InputValidator.validateDate(request.getEndDate());

        long days = dateCalculationService.calculateDaysBetween(
                request.getStartDate(),
                request.getEndDate()
        );

        return new DateDiffResponse(days);
    }




    @PostMapping("/number-to-words")
    public NumberToWordsResponse numberToWords(
            @RequestBody NumberToWordsRequest request) {

        InputValidator.validateNumber(request.getNumber());

        String words = numberToWordsService.convert(request.getNumber());

        return new NumberToWordsResponse(words);
    }




    @PostMapping("/temperature-stats-for-dhaka")
    public TemperatureStatsResponse temperatureStats(
            @RequestBody TemperatureStatsRequest request) {

        InputValidator.validateDate(request.getStartDate());
        InputValidator.validateDate(request.getEndDate());

        Object[] stats = temperatureStatsService.calculate(
            request.getStartDate(),
            request.getEndDate()
        );

        return new TemperatureStatsResponse(
            (double) stats[0],
            (double) stats[1],
            (double) stats[2],
            (String) stats[3],
            (String) stats[4],
            (String) stats[5]
        );
    }
}
