package com.carrentals.controller;

import com.carrentals.entity.Booking;
import com.carrentals.entity.RentalCar;
import com.carrentals.service.CarRentalsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRentalsController {

    private final CarRentalsService service;

    public CarRentalsController(CarRentalsService service) {
        this.service = service;
    }

    @GetMapping("/rentalcardetails")
    public List<RentalCar> getRentalCars() {
        return service.getAllRentalCars();
    }

    @GetMapping("/bookingdetails")
    public List<Booking> getBookingDetails() {
        return service.getAllBookings();
    }
}