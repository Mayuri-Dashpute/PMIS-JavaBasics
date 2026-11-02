package com.fleet.maintenance.rowmapper;

import com.fleet.maintenance.model.Vehicle;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleRowMapper implements RowMapper<Vehicle> {

    @Override
    public Vehicle mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        return new Vehicle(
                rs.getString("reg_number"),
                rs.getString("model"),
                rs.getInt("current_odometer"),
                rs.getInt("last_service_odometer"),
                rs.getString("status")
        );
    }
}