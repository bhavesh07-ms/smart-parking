package com.bhavesh.smartparking.smart_parking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ParkingTransaction {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private ParkingSpot spot;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private double fee;

    // getters, setters
}
