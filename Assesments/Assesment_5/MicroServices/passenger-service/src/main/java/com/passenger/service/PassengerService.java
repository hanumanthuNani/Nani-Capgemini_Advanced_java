package com.passenger.service;

import com.passenger.dto.RentalCarDTO;
import com.passenger.feign.CarRentalClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private final CarRentalClient client;

    public PassengerService(CarRentalClient client) {
        this.client = client;
    }

    public List<RentalCarDTO> getRentalCars() {
        return client.getCars();
    }
}