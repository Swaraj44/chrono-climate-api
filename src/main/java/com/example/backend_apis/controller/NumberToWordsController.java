package com.example.backend_apis.controller;

import com.example.backend_apis.dto.NumberToWordsRequest;
import com.example.backend_apis.dto.NumberToWordsResponse;
import com.example.backend_apis.service.NumberToWordsService;
import com.example.backend_apis.util.InputValidator;

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
