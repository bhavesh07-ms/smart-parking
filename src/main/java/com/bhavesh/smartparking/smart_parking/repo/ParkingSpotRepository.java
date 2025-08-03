package com.bhavesh.smartparking.smart_parking.repo;

import com.bhavesh.smartparking.smart_parking.entity.ParkingSpot;
import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findFirstByOccupiedFalseAndAllowedType(VehicleType type);
}