package com.company.carpark.dto;

public class ParkingStatusResponse {

    private int availableSpaces;
    private int occupiedSpaces;

    public ParkingStatusResponse(
            int availableSpaces,
            int occupiedSpaces) {

        this.availableSpaces = availableSpaces;
        this.occupiedSpaces = occupiedSpaces;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public int getOccupiedSpaces() {
        return occupiedSpaces;
    }
}