package com.bhavesh.smartparking.smart_parking.repo;

import com.bhavesh.smartparking.smart_parking.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {}