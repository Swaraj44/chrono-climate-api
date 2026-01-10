package com.example.backend_apis.controller;
import org.springframework.web.bind.annotation.*;





@RestController        
public class BackendApiController {


    @GetMapping("/")
    public String home() {
        return "{'message':'Welcome to Backend Engineer Tasks'}";
    }


    @GetMapping("/health")
    public String health() {
        return "{'status':'ok', 'model version':'1.0.0'}";
    }
 
}
