package com.fleet.maintenance.dao;


import com.fleet.maintenance.model.FuelEntry;
import com.fleet.maintenance.rowmapper.FuelEntryRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FuelEntryDao {

    private final JdbcTemplate jdbcTemplate;

    public FuelEntryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add fuel entry
    public int addFuelEntry(FuelEntry fuelEntry) {

        String sql = """
            INSERT INTO fuel_entries
            (reg_number, litres, cost, odometer_reading)
            VALUES (?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
                sql,
                fuelEntry.regNumber(),
                fuelEntry.litres(),
                fuelEntry.cost(),
                fuelEntry.odometerReading()
        );
    }

    // Get fuel entries of a vehicle
    public List<FuelEntry> getFuelEntriesByVehicle(String regNumber) {

        String sql = """
            SELECT * FROM fuel_entries
            WHERE reg_number = ?
            ORDER BY fuel_date, entry_id
            """;

        return jdbcTemplate.query(
                sql,
                new FuelEntryRowMapper(),
                regNumber
        );
    }

    // Calculate mileage between consecutive fuel entries
    public List<Map<String, Object>> calculateMileage(String regNumber) {

        String sql = """
            SELECT
                odometer_reading,
                previous_odometer,
                litres,
                ROUND(
                    (odometer_reading - previous_odometer) / litres,
                    2
                ) AS mileage

            FROM (
                SELECT
                    odometer_reading,
                    litres,
                    LAG(odometer_reading) OVER (
                        PARTITION BY reg_number
                        ORDER BY fuel_date, entry_id
                    ) AS previous_odometer

                FROM fuel_entries
                WHERE reg_number = ?
            ) AS fuel_data

            WHERE previous_odometer IS NOT NULL
              AND odometer_reading > previous_odometer
            """;

        return jdbcTemplate.queryForList(sql, regNumber);
    }
}