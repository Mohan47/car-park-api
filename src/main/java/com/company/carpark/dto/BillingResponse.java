package com.company.carpark.dto;

import java.time.LocalDateTime;

public class BillingResponse {

    private String vehicleReg;
    private double vehicleCharge;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public BillingResponse(
            String vehicleReg,
            double vehicleCharge,
            LocalDateTime timeIn,
            LocalDateTime timeOut) {

        this.vehicleReg = vehicleReg;
        this.vehicleCharge = vehicleCharge;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public double getVehicleCharge() {
        return vehicleCharge;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }
}