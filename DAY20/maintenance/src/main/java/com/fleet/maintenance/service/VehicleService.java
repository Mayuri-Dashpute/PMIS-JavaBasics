package com.fleet.maintenance.service;

import com.fleet.maintenance.dao.VehicleDao;
import com.fleet.maintenance.dao.ServiceRecordDao;
import com.fleet.maintenance.model.Vehicle;
import com.fleet.maintenance.model.ServiceRecord;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleDao vehicleDao;
    private final ServiceRecordDao serviceRecordDao;

    public VehicleService(
            VehicleDao vehicleDao,
            ServiceRecordDao serviceRecordDao) {

        this.vehicleDao = vehicleDao;
        this.serviceRecordDao = serviceRecordDao;
    }

    // Register vehicle with baseline service record
    @Transactional
    public void registerVehicle(Vehicle vehicle) {

        if (vehicle.currentOdometer() < 0 ||
                vehicle.lastServiceOdometer() < 0 ||
                vehicle.lastServiceOdometer() >
                        vehicle.currentOdometer()) {

            throw new IllegalArgumentException(
                    "Invalid odometer readings");
        }

        vehicleDao.addVehicle(vehicle);

        ServiceRecord baseline = new ServiceRecord(
                0,
                vehicle.regNumber(),
                "INITIAL_BASELINE",
                BigDecimal.ZERO,
                vehicle.lastServiceOdometer(),
                LocalDate.now()
        );

        serviceRecordDao.addServiceRecord(baseline);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    public Vehicle getVehicle(String regNumber) {
        return vehicleDao.getVehicleById(regNumber);
    }
}