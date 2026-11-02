package com.fleet.maintenance.rowmapper;


import com.fleet.maintenance.model.ServiceRecord;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRecordRowMapper
        implements RowMapper<ServiceRecord> {

    @Override
    public ServiceRecord mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        return new ServiceRecord(
                rs.getInt("service_id"),
                rs.getString("reg_number"),
                rs.getString("service_type"),
                rs.getBigDecimal("service_cost"),
                rs.getInt("service_odometer"),
                rs.getDate("service_date").toLocalDate()
        );
    }
}