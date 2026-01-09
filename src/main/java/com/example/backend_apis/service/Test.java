package com.example.backend_apis.service;

import org.springframework.stereotype.Service;


@Service
public class Test {

        private final NumberToWordsService numberToWordsService;

        public Test(NumberToWordsService numberToWordsService) {
        this.numberToWordsService = numberToWordsService;
    }

        public Object[] testt() {

        double[] stats = {69.5, 94.2, 69.94};

        return new Object[] {
                stats[0],
                stats[1],
                stats[2],
                numberToWordsService.convert(String.valueOf(stats[0])),
                numberToWordsService.convert(String.valueOf(stats[1])),
                numberToWordsService.convert(String.valueOf(stats[2]))
        };
    }
    
}
