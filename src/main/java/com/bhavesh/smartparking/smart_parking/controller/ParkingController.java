package com.bhavesh.smartparking.smart_parking.controller;

import com.bhavesh.smartparking.smart_parking.enums.VehicleType;
import com.bhavesh.smartparking.smart_parking.service.ParkingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    @PostMapping("/checkin")
    public String checkIn(@RequestParam String licensePlate,
                          @RequestParam VehicleType type) {
        return service.checkIn(licensePlate, type);
    }

    @PostMapping("/checkout")
    public String checkOut(@RequestParam String licensePlate) {
        return service.checkOut(licensePlate);
    }
}
