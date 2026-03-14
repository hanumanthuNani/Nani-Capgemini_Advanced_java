package com.carrentals.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "booking_date")
    private String bookingDate;

    // Default Constructor
    public Booking() {}

    // Full Constructor
    public Booking(Integer id, String passengerName, Integer carId, String bookingDate) {
        this.id = id;
        this.passengerName = passengerName;
        this.carId = carId;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public Integer getCarId() { return carId; }
    public void setCarId(Integer carId) { this.carId = carId; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
}