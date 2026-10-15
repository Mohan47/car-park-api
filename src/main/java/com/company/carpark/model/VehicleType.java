package com.company.carpark.model;

public enum VehicleType {

    SMALL(1, 0.10),
    MEDIUM(2, 0.20),
    LARGE(3, 0.40);

    private final int code;
    private final double rate;

    VehicleType(int code, double rate) {
        this.code = code;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static VehicleType fromCode(int code) {

        for (VehicleType type : values()) {

            if (type.code == code) {
                return type;
            }
        }

        throw new IllegalArgumentException(
                "Vehicle type must be 1, 2 or 3");
    }
}