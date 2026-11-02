package com.fleet.maintenance.dao;


import com.fleet.maintenance.model.ServiceRecord;
import com.fleet.maintenance.rowmapper.ServiceRecordRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceRecordDao {

    private final JdbcTemplate jdbcTemplate;

    public ServiceRecordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add service record
    public int addServiceRecord(ServiceRecord record) {

        String sql = """
            INSERT INTO service_records
            (reg_number, service_type, service_cost,
             service_odometer, service_date)
            VALUES (?, ?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
                sql,
                record.regNumber(),
                record.serviceType(),
                record.serviceCost(),
                record.serviceOdometer(),
                record.serviceDate()
        );
    }

    // Get service records
    public List<ServiceRecord> getServiceRecords(String regNumber) {

        String sql = """
            SELECT * FROM service_records
            WHERE reg_number = ?
            ORDER BY service_date DESC, service_id DESC
            """;

        return jdbcTemplate.query(
                sql,
                new ServiceRecordRowMapper(),
                regNumber
        );
    }
}