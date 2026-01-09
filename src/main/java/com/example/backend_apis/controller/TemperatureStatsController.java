package com.example.backend_apis.controller;

import com.example.backend_apis.dto.TemperatureStatsRequest;
import com.example.backend_apis.dto.TemperatureStatsResponse;
import com.example.backend_apis.service.TemperatureStatsService;
import com.example.backend_apis.util.InputValidator;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class TemperatureStatsController {

    private final TemperatureStatsService service;
  

    public TemperatureStatsController(TemperatureStatsService service) {
        this.service = service;
    }

    @PostMapping("/temperature-stats-for-dhaka")
    public TemperatureStatsResponse getStats(@RequestBody TemperatureStatsRequest request) {
        InputValidator.validateDate(request.getStartDate());
        InputValidator.validateDate(request.getEndDate());

        Object[] result = service.calculate(request.getStartDate(),request.getEndDate());


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
