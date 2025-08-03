package com.bhavesh.smartparking.smart_parking.entity;

import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    // getters, setters
}