package com.company.carpark.dto;

import java.time.LocalDateTime;

public class ParkingResponse {

    private String vehicleReg;
    private LocalDateTime timeIn;

    public ParkingResponse(String vehicleReg,
                           LocalDateTime timeIn) {

        this.vehicleReg = vehicleReg;
        this.timeIn = timeIn;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }
}