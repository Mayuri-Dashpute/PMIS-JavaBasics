package com.fleet.maintenance.service;


import com.fleet.maintenance.dao.VehicleDao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuditService {

    private final VehicleDao vehicleDao;

    public AuditService(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public List<Map<String, Object>> getCostReport() {

        return vehicleDao.getOperationalCostReport();
    }
}