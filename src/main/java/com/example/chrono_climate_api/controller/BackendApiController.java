package com.example.chrono_climate_api.controller;
import org.springframework.web.bind.annotation.*;




@RestController  
@RequestMapping("/")      
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
