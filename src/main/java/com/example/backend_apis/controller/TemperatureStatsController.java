package com.example.backend_apis.controller;

import com.example.backend_apis.dto.TemperatureStatsRequest;
import com.example.backend_apis.dto.TemperatureStatsResponse;
import com.example.backend_apis.service.TemperatureStatsService;
import com.example.backend_apis.service.Test;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class TemperatureStatsController {

    private final TemperatureStatsService service;
    private final Test test;

    public TemperatureStatsController(TemperatureStatsService service, Test test) {
        this.service = service;
        this.test=test;
    }

    @PostMapping("/temperature-stats-for-dhaka")
    public TemperatureStatsResponse getStats(@RequestBody TemperatureStatsRequest request) {

        Object[] result = service.calculate(
                request.getStartDate(),
                request.getEndDate()
        );

        //Object[] result2 = test.testt();

        //System.out.println("--->  Request: " + request.getStartDate() + " to " + request.getEndDate()); 

        return new TemperatureStatsResponse(
                (double) result[0],
                (double) result[1],
                (double) result[2],
                (String) result[3],
                (String) result[4],
                (String) result[5]
        );
    }
}
