package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FallBackController {

    @GetMapping("/fallback/passenger")
    public Map<String, String> passengerFallback() {
        return Map.of(
                "message", "Passenger Service is currently unavailable. Please try again later."
        );
    }

    @GetMapping("/fallback/carrentals")
    public Map<String, String> carrentalsFallback() {
        return Map.of(
                "message", "Car Rentals Service is currently unavailable. Please try again later."
        );
    }
}