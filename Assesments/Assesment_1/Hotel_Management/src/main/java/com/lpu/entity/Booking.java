package com.lpu.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;

    // No-arg constructor (required by Hibernate)
    public Booking() {}

    // Correct parameterized constructor using LocalDate
    public Booking(String customerName, String roomType,
                   LocalDate checkInDate, LocalDate checkOutDate) {
        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateAmount();
    }

    // Correct real-world calculation
    private double calculateAmount() {

        long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

        int pricePerDay = switch (roomType) {
            case "Standard" -> 2000;
            case "Deluxe" -> 3500;
            case "Suite" -> 5000;
            default -> 0;
        };

        return days * pricePerDay;
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public String getRoomType() { return roomType; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public double getTotalAmount() { return totalAmount; }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        this.totalAmount = calculateAmount();
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        this.totalAmount = calculateAmount();
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateAmount();
    }
}
