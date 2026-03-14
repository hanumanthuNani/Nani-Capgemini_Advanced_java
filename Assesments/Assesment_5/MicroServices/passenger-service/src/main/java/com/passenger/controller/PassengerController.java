package com.passenger.controller;

import com.passenger.dto.RentalCarDTO;
import com.passenger.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping("/details")
    public List<RentalCarDTO> getPassengerDetails() {
        return service.getRentalCars();
    }
}