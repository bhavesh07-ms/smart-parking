package com.bhavesh.smartparking.smart_parking.entity;

import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ParkingSpot {
    @Id
    @GeneratedValue
    private Long id;

    private boolean occupied;

    @Enumerated(EnumType.STRING)
    private VehicleType allowedType;

    @ManyToOne
    @JoinColumn(name="floor_id")
    private ParkingFloor floor;

    // getters, setters
}
