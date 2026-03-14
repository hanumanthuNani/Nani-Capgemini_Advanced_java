package com.carrentals.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rental_car")
public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "price_per_day")
    private Double pricePerDay;

    public Integer getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
}