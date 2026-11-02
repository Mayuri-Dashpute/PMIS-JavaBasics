package com.fleet.maintenance.rowmapper;


import com.fleet.maintenance.model.FuelEntry;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuelEntryRowMapper implements RowMapper<FuelEntry> {

    @Override
    public FuelEntry mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        return new FuelEntry(
                rs.getInt("entry_id"),
                rs.getString("reg_number"),
                rs.getBigDecimal("litres"),
                rs.getBigDecimal("cost"),
                rs.getInt("odometer_reading"),
                rs.getTimestamp("fuel_date").toLocalDateTime()
        );
    }
}