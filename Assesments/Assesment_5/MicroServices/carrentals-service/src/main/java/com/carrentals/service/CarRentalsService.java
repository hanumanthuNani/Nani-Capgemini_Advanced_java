package com.carrentals.service;

import com.carrentals.entity.Booking;
import com.carrentals.entity.RentalCar;
import com.carrentals.repository.BookingRepository;
import com.carrentals.repository.RentalCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentalsService {

    private final RentalCarRepository rentalCarRepository;
    private final BookingRepository bookingRepository;

    public CarRentalsService(RentalCarRepository rentalCarRepository,
                             BookingRepository bookingRepository) {
        this.rentalCarRepository = rentalCarRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<RentalCar> getAllRentalCars() {
        return rentalCarRepository.findAll();
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}