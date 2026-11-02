package com.fleet.maintenance.dao;

import com.fleet.maintenance.model.Vehicle;
import com.fleet.maintenance.rowmapper.VehicleRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VehicleDao {

    private final JdbcTemplate jdbcTemplate;

    public VehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Register vehicle
    public int addVehicle(Vehicle vehicle) {

        String sql = """
            INSERT INTO vehicles
            (reg_number, model, current_odometer,
             last_service_odometer, status)
            VALUES (?, ?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
                sql,
                vehicle.regNumber(),
                vehicle.model(),
                vehicle.currentOdometer(),
                vehicle.lastServiceOdometer(),
                vehicle.status()
        );
    }

    // Display all vehicles
    public List<Vehicle> getAllVehicles() {

        String sql = "SELECT * FROM vehicles ORDER BY reg_number";

        return jdbcTemplate.query(sql, new VehicleRowMapper());
    }

    // Find vehicle
    public Vehicle getVehicleById(String regNumber) {

        String sql = """
            SELECT * FROM vehicles
            WHERE reg_number = ?
            """;

        List<Vehicle> vehicles = jdbcTemplate.query(
                sql,
                new VehicleRowMapper(),
                regNumber
        );

        return vehicles.isEmpty() ? null : vehicles.get(0);
    }

    // Update current odometer
    public int updateOdometer(String regNumber, int odometer) {

        String sql = """
            UPDATE vehicles
            SET current_odometer = ?
            WHERE reg_number = ?
            """;

        return jdbcTemplate.update(sql, odometer, regNumber);
    }

    // Update last service odometer
    public int updateLastServiceOdometer(
            String regNumber, int odometer) {

        String sql = """
            UPDATE vehicles
            SET last_service_odometer = ?
            WHERE reg_number = ?
            """;

        return jdbcTemplate.update(sql, odometer, regNumber);
    }

    // Maintenance alerts
    public List<Vehicle> getVehiclesDueForService() {

        String sql = """
            SELECT * FROM vehicles
            WHERE current_odometer - last_service_odometer >= 5000
            """;

        return jdbcTemplate.query(sql, new VehicleRowMapper());
    }

    // Fleet operational cost report
    public List<Map<String, Object>> getOperationalCostReport() {

        String sql = """
            SELECT
                v.reg_number,
                v.model,
                COALESCE(f.fuel_cost, 0) AS total_fuel_cost,
                COALESCE(s.service_cost, 0) AS total_service_cost,
                COALESCE(f.fuel_cost, 0) +
                COALESCE(s.service_cost, 0) AS total_operational_cost

            FROM vehicles v

            LEFT JOIN (
                SELECT reg_number, SUM(cost) AS fuel_cost
                FROM fuel_entries
                GROUP BY reg_number
            ) f ON v.reg_number = f.reg_number

            LEFT JOIN (
                SELECT reg_number, SUM(service_cost) AS service_cost
                FROM service_records
                GROUP BY reg_number
            ) s ON v.reg_number = s.reg_number

            ORDER BY v.reg_number
            """;

        return jdbcTemplate.queryForList(sql);
    }
}
