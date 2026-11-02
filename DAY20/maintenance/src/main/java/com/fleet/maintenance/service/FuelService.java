package com.fleet.maintenance.service;


import com.fleet.maintenance.dao.FuelEntryDao;
import com.fleet.maintenance.dao.VehicleDao;

import com.fleet.maintenance.model.FuelEntry;
import com.fleet.maintenance.model.Vehicle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class FuelService {

    private final FuelEntryDao fuelEntryDao;
    private final VehicleDao vehicleDao;

    public FuelService(
            FuelEntryDao fuelEntryDao,
            VehicleDao vehicleDao) {

        this.fuelEntryDao = fuelEntryDao;
        this.vehicleDao = vehicleDao;
    }

    // Add fuel and update vehicle odometer
    @Transactional
    public void addFuelEntry(FuelEntry entry) {

        Vehicle vehicle =
                vehicleDao.getVehicleById(entry.regNumber());

        if (vehicle == null) {
            throw new IllegalArgumentException(
                    "Vehicle not found");
        }

        if (!"ACTIVE".equals(vehicle.status())) {
            throw new IllegalStateException(
                    "Only ACTIVE vehicles can receive fuel entries");
        }

        if (entry.litres() == null ||
                entry.litres().compareTo(BigDecimal.ZERO) <= 0 ||
                entry.cost() == null ||
                entry.cost().compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "Litres and cost must be greater than zero");
        }

        if (entry.odometerReading() < vehicle.currentOdometer()) {
            throw new IllegalArgumentException(
                    "New odometer cannot be less than current odometer");
        }

        fuelEntryDao.addFuelEntry(entry);

        vehicleDao.updateOdometer(
                entry.regNumber(),
                entry.odometerReading()
        );
    }

    // Calculate mileage
    public List<Map<String, Object>> calculateMileage(
            String regNumber) {

        if (vehicleDao.getVehicleById(regNumber) == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }

        return fuelEntryDao.calculateMileage(regNumber);
    }
}