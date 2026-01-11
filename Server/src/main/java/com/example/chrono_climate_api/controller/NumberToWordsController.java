package com.example.chrono_climate_api.controller;

import com.example.chrono_climate_api.dto.NumberToWordsRequest;
import com.example.chrono_climate_api.dto.NumberToWordsResponse;
import com.example.chrono_climate_api.service.NumberToWordsService;
import com.example.chrono_climate_api.util.InputValidator;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class NumberToWordsController {

    private final NumberToWordsService service;

    public NumberToWordsController(NumberToWordsService service) {
        this.service = service;
    }


    
    @PostMapping("/number-to-words")
    public NumberToWordsResponse convert(@RequestBody NumberToWordsRequest request) {

    InputValidator.validateNumber(request.getNumber());

    String words = service.convert(request.getNumber());

    return new NumberToWordsResponse(words);
    }


    
}
