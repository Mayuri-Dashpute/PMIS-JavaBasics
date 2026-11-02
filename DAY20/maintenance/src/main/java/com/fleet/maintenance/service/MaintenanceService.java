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
public class MaintenanceService {

    private final VehicleDao vehicleDao;
    private final ServiceRecordDao serviceRecordDao;

    public MaintenanceService(
            VehicleDao vehicleDao,
            ServiceRecordDao serviceRecordDao) {

        this.vehicleDao = vehicleDao;
        this.serviceRecordDao = serviceRecordDao;
    }

    // Get vehicles due for maintenance
    public List<Vehicle> getMaintenanceAlerts() {

        return vehicleDao.getVehiclesDueForService();
    }

    // Add service record
    @Transactional
    public void addServiceRecord(ServiceRecord record) {

        Vehicle vehicle =
                vehicleDao.getVehicleById(record.regNumber());

        if (vehicle == null) {
            throw new IllegalArgumentException(
                    "Vehicle not found");
        }

        if (record.serviceCost() == null ||
                record.serviceCost().compareTo(BigDecimal.ZERO) < 0) {

            throw new IllegalArgumentException(
                    "Service cost cannot be negative");
        }

        if (record.serviceOdometer() <
                vehicle.currentOdometer()) {

            throw new IllegalArgumentException(
                    "Service odometer cannot be less than current odometer");
        }

        if (record.serviceDate() == null ||
                record.serviceDate().isAfter(LocalDate.now())) {

            throw new IllegalArgumentException(
                    "Invalid service date");
        }

        serviceRecordDao.addServiceRecord(record);

        // Update service baseline
        vehicleDao.updateLastServiceOdometer(
                record.regNumber(),
                record.serviceOdometer()
        );

        // Update current odometer if necessary
        vehicleDao.updateOdometer(
                record.regNumber(),
                record.serviceOdometer()
        );
    }

    public List<ServiceRecord> getServiceRecords(String regNumber) {

        return serviceRecordDao.getServiceRecords(regNumber);
    }
}