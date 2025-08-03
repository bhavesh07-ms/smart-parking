package com.bhavesh.smartparking.smart_parking.repo;

import com.bhavesh.smartparking.smart_parking.entity.RateCard;
import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RateCardRepository extends JpaRepository<RateCard, Long> {
    Optional<RateCard> findByType(VehicleType type);
}