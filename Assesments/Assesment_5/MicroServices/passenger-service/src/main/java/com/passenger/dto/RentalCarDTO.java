package com.passenger.dto;

public class RentalCarDTO {

    private Integer id;
    private String carName;
    private String carModel;
    private Double pricePerDay;

    // Default Constructor (Needed for JSON mapping)
    public RentalCarDTO() {}

    // Full Constructor
    public RentalCarDTO(Integer id, String carName, String carModel, Double pricePerDay) {
        this.id = id;
        this.carName = carName;
        this.carModel = carModel;
        this.pricePerDay = pricePerDay;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }

    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }

    public Double getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(Double pricePerDay) { this.pricePerDay = pricePerDay; }
}