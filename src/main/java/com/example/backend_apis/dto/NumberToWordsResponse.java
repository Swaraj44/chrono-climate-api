package com.example.backend_apis.dto;


public class NumberToWordsResponse {

    private String words;

    public NumberToWordsResponse(String words) {
        this.words = words;
    }


    public String getWords() {
        return words;
    }
}
