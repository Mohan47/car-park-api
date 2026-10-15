package com.company.carpark.service;

import com.company.carpark.dto.BillingRequest;
import com.company.carpark.dto.BillingResponse;
import com.company.carpark.dto.ParkVehicleRequest;
import com.company.carpark.dto.ParkingResponse;
import com.company.carpark.dto.ParkingStatusResponse;
import com.company.carpark.model.ParkingRecord;
import com.company.carpark.model.VehicleType;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static final int TOTAL_SPACES = 10;

    private final Map<String, ParkingRecord> parkedVehicles =
            new HashMap<>();

    public ParkingStatusResponse getStatus() {

        int occupied = parkedVehicles.size();

        return new ParkingStatusResponse(
                TOTAL_SPACES - occupied,
                occupied
        );
    }

    public ParkingResponse parkVehicle(
            ParkVehicleRequest request) {

        if (parkedVehicles.containsKey(
                request.getVehicleReg())) {

            throw new RuntimeException(
                    "Vehicle already parked");
        }

        if (parkedVehicles.size() >= TOTAL_SPACES) {

            throw new RuntimeException(
                    "Car park is full");
        }

        VehicleType vehicleType =
                VehicleType.fromCode(
                        request.getVehicleType());

        int space =
                findFirstAvailableSpace();

        ParkingRecord record =
                new ParkingRecord(
                        request.getVehicleReg(),
                        vehicleType,
                        space,
                        LocalDateTime.now()
                );

        parkedVehicles.put(
                record.getVehicleReg(),
                record
        );

        return new ParkingResponse(
                record.getVehicleReg(),
                record.getTimeIn()
        );
    }

    public BillingResponse generateBill(
            BillingRequest request) {

        ParkingRecord record =
                parkedVehicles.get(
                        request.getVehicleReg());

        if (record == null) {

            throw new RuntimeException(
                    "Vehicle not found");
        }

        LocalDateTime timeOut =
                LocalDateTime.now();

        long minutes =
                Duration.between(
                                record.getTimeIn(),
                                timeOut)
                        .toMinutes();

        double charge =
                calculateCharge(
                        record.getVehicleType(),
                        minutes);

        parkedVehicles.remove(
                record.getVehicleReg());

        return new BillingResponse(
                record.getVehicleReg(),
                charge,
                record.getTimeIn(),
                timeOut
        );
    }

    private int findFirstAvailableSpace() {

        Set<Integer> occupiedSpaces =
                parkedVehicles.values()
                        .stream()
                        .map(ParkingRecord::getSpaceNumber)
                        .collect(Collectors.toSet());

        for (int i = 1; i <= TOTAL_SPACES; i++) {

            if (!occupiedSpaces.contains(i)) {
                return i;
            }
        }

        throw new RuntimeException(
                "No space available");
    }

    private double calculateCharge(
            VehicleType vehicleType,
            long minutes) {

        double parkingCharge =
                minutes * vehicleType.getRate();

        double extraCharge =
                (minutes / 5) * 1.0;

        return parkingCharge + extraCharge;
    }
}