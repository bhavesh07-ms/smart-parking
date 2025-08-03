package com.bhavesh.smartparking.smart_parking.service;

import com.bhavesh.smartparking.smart_parking.entity.ParkingSpot;
import com.bhavesh.smartparking.smart_parking.entity.ParkingTransaction;
import com.bhavesh.smartparking.smart_parking.entity.Vehicle;
import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import com.bhavesh.smartparking.smart_parking.repo.ParkingSpotRepository;
import com.bhavesh.smartparking.smart_parking.repo.ParkingTransactionRepository;
import com.bhavesh.smartparking.smart_parking.repo.RateCardRepository;
import com.bhavesh.smartparking.smart_parking.repo.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingSpotRepository spotRepo;
    private final VehicleRepository vehicleRepo;
    private final ParkingTransactionRepository txnRepo;
    private final RateCardRepository rateRepo;



    @Transactional
    public String checkIn(String licensePlate, VehicleType type) {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(licensePlate);
        vehicle.setType(type);
        vehicleRepo.save(vehicle);

        ParkingSpot spot = spotRepo.findFirstByOccupiedFalseAndAllowedType(type)
                .orElseThrow(() -> new RuntimeException("No spot available"));

        spot.setOccupied(true);
        spotRepo.save(spot);

        ParkingTransaction txn = new ParkingTransaction();
        txn.setVehicle(vehicle);
        txn.setSpot(spot);
        txn.setEntryTime(LocalDateTime.now());
        txnRepo.save(txn);

        return "Vehicle parked at spot: " + spot.getId();
    }

    @Transactional
    public String checkOut(String licensePlate) {
        ParkingTransaction txn = txnRepo.findByVehicleLicensePlateAndExitTimeIsNull(licensePlate)
                .orElseThrow(() -> new RuntimeException("No active parking found"));

        LocalDateTime now = LocalDateTime.now();
        txn.setExitTime(now);

        Duration duration = Duration.between(txn.getEntryTime(), now);
        long hours = Math.max(1, duration.toHours());

        VehicleType type = txn.getVehicle().getType();
        double rate = rateRepo.findByType(type)
                .orElseThrow(() -> new RuntimeException("Rate not found"))
                .getRatePerHour();

        double fee = hours * rate;
        txn.setFee(fee);

        txn.getSpot().setOccupied(false);
        spotRepo.save(txn.getSpot());

        txnRepo.save(txn);
        return "Total fee: Rs. " + fee;
    }
}

