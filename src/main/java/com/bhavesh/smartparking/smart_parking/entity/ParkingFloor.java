package com.bhavesh.smartparking.smart_parking.entity;

import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ParkingFloor {
    @Id
    @GeneratedValue
    private Long id;

    private int floorNumber;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<ParkingSpot> spots;


    public boolean isAvailable(VehicleType type) {
        return spots.stream().anyMatch(s -> !s.isOccupied() && s.getAllowedType() == type);
    }

    // getters, setters
}
