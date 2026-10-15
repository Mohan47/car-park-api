package com.company.carpark.controller;

import com.company.carpark.dto.*;
import com.company.carpark.service.ParkingService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(
            ParkingService parkingService) {

        this.parkingService = parkingService;
    }

    @GetMapping
    public ParkingStatusResponse getStatus() {

        return parkingService.getStatus();
    }

    @PostMapping
    public ParkingResponse parkVehicle(
            @RequestBody
            ParkVehicleRequest request) {

        return parkingService
                .parkVehicle(request);
    }

    @PostMapping("/bill")
    public BillingResponse generateBill(
            @RequestBody
            BillingRequest request) {

        return parkingService
                .generateBill(request);
    }
}