package com.bhavesh.smartparking.smart_parking.repo;

import com.bhavesh.smartparking.smart_parking.entity.ParkingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingTransactionRepository extends JpaRepository<ParkingTransaction, Long> {
    Optional<ParkingTransaction> findByVehicleLicensePlateAndExitTimeIsNull(String licensePlate);
}
