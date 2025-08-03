package com.bhavesh.smartparking.smart_parking.entity;

import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RateCard {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private double ratePerHour;


}

