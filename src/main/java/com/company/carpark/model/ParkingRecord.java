package com.company.carpark.model;

import java.time.LocalDateTime;

public class ParkingRecord {

    private String vehicleReg;
    private VehicleType vehicleType;
    private int spaceNumber;
    private LocalDateTime timeIn;

    public ParkingRecord(String vehicleReg,
                         VehicleType vehicleType,
                         int spaceNumber,
                         LocalDateTime timeIn) {

        this.vehicleReg = vehicleReg;
        this.vehicleType = vehicleType;
        this.spaceNumber = spaceNumber;
        this.timeIn = timeIn;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }
}