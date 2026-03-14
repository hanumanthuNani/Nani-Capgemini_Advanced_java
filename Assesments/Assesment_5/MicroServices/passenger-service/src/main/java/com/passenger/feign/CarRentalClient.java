package com.passenger.feign;

import com.passenger.dto.RentalCarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "carrentals-service")
public interface CarRentalClient {

    @GetMapping("/cars/rentalcardetails")
    List<RentalCarDTO> getCars();
}