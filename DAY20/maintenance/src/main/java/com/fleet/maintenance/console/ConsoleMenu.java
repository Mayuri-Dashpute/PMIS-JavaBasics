package com.fleet.maintenance.console;


import com.fleet.maintenance.model.Vehicle;
import com.fleet.maintenance.model.FuelEntry;
import com.fleet.maintenance.model.ServiceRecord;

import com.fleet.maintenance.service.VehicleService;
import com.fleet.maintenance.service.FuelService;
import com.fleet.maintenance.service.MaintenanceService;
import com.fleet.maintenance.service.AuditService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ConsoleMenu implements CommandLineRunner {

    private final VehicleService vehicleService;
    private final FuelService fuelService;
    private final MaintenanceService maintenanceService;
    private final AuditService auditService;

    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(
            VehicleService vehicleService,
            FuelService fuelService,
            MaintenanceService maintenanceService,
            AuditService auditService) {

        this.vehicleService = vehicleService;
        this.fuelService = fuelService;
        this.maintenanceService = maintenanceService;
        this.auditService = auditService;
    }

    @Override
    public void run(String... args) {

        System.out.println("\n==================================");
        System.out.println("   FLEET MANAGEMENT SYSTEM");
        System.out.println("==================================");

        boolean running = true;

        while (running) {

            displayMenu();

            try {
                System.out.print("\nEnter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 -> registerVehicle();

                    case 2 -> displayVehicles();

                    case 3 -> addFuelEntry();

                    case 4 -> calculateMileage();

                    case 5 -> maintenanceAlerts();

                    case 6 -> addServiceRecord();

                    case 7 -> costAudit();

                    case 8 -> {
                        running = false;
                        System.out.println("Thank you! Application closed.");
                    }

                    default ->
                            System.out.println("Invalid choice!");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {

        System.out.println("\n----------- MAIN MENU -----------");

        System.out.println("1. Register Vehicle");
        System.out.println("2. View All Vehicles");
        System.out.println("3. Add Fuel Entry");
        System.out.println("4. Calculate Mileage");
        System.out.println("5. Maintenance Alerts");
        System.out.println("6. Add Service Record");
        System.out.println("7. Fleet Cost Audit");
        System.out.println("8. Exit");
    }

    // 1. Register vehicle
    private void registerVehicle() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine();

        System.out.print("Vehicle Model: ");
        String model = scanner.nextLine();

        System.out.print("Current Odometer: ");
        int current = Integer.parseInt(scanner.nextLine());

        System.out.print("Last Service Odometer: ");
        int lastService = Integer.parseInt(scanner.nextLine());

        Vehicle vehicle = new Vehicle(
                reg,
                model,
                current,
                lastService,
                "ACTIVE"
        );

        vehicleService.registerVehicle(vehicle);

        System.out.println("Vehicle registered successfully!");
    }

    // 2. Display vehicles
    private void displayVehicles() {

        List<Vehicle> vehicles =
                vehicleService.getAllVehicles();

        System.out.println("\n---------- VEHICLE FLEET ----------");

        for (Vehicle v : vehicles) {

            int distance =
                    v.currentOdometer() -
                            v.lastServiceOdometer();

            System.out.println("--------------------------------");
            System.out.println("Registration: " + v.regNumber());
            System.out.println("Model: " + v.model());
            System.out.println("Current KM: " + v.currentOdometer());
            System.out.println("Last Service KM: " +
                    v.lastServiceOdometer());
            System.out.println("Status: " + v.status());

            System.out.println("Maintenance: " +
                    (distance >= 5000 ? "DUE FOR SERVICE" : "UP TO DATE"));
        }
    }

    // 3. Add fuel
    private void addFuelEntry() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine();

        System.out.print("Fuel Litres: ");
        BigDecimal litres =
                new BigDecimal(scanner.nextLine());

        System.out.print("Fuel Cost: ");
        BigDecimal cost =
                new BigDecimal(scanner.nextLine());

        System.out.print("Current Odometer: ");
        int odometer =
                Integer.parseInt(scanner.nextLine());

        FuelEntry entry = new FuelEntry(
                0,
                reg,
                litres,
                cost,
                odometer,
                null
        );

        fuelService.addFuelEntry(entry);

        System.out.println("Fuel entry added successfully!");
        System.out.println("Vehicle odometer updated!");
    }

    // 4. Calculate mileage
    private void calculateMileage() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine();

        List<Map<String, Object>> mileage =
                fuelService.calculateMileage(reg);

        if (mileage.isEmpty()) {
            System.out.println(
                    "Not enough valid fuel entries to calculate mileage.");
            return;
        }

        System.out.println("\n---------- MILEAGE REPORT ----------");

        for (Map<String, Object> row : mileage) {

            double value =
                    ((Number) row.get("mileage")).doubleValue();

            System.out.println("Odometer: " +
                    row.get("odometer_reading"));

            System.out.println("Mileage: " +
                    value + " km/litre");

            if (value < 5.0) {
                System.out.println("WARNING: LOW MILEAGE ANOMALY!");
            } else {
                System.out.println("Mileage: NORMAL");
            }

            System.out.println("--------------------------------");
        }
    }

    // 5. Maintenance alerts
    private void maintenanceAlerts() {

        List<Vehicle> vehicles =
                maintenanceService.getMaintenanceAlerts();

        System.out.println("\n---------- MAINTENANCE ALERTS ----------");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles require maintenance.");
            return;
        }

        for (Vehicle v : vehicles) {

            int distance =
                    v.currentOdometer() -
                            v.lastServiceOdometer();

            System.out.println("Vehicle: " + v.regNumber());

            System.out.println("Distance since service: " +
                    distance + " km");

            System.out.println("WARNING: SERVICE REQUIRED!");
            System.out.println("--------------------------------");
        }
    }

    // 6. Add service
    private void addServiceRecord() {

        System.out.print("Registration Number: ");
        String reg = scanner.nextLine();

        System.out.print("Service Type: ");
        String type = scanner.nextLine();

        System.out.print("Service Cost: ");
        BigDecimal cost =
                new BigDecimal(scanner.nextLine());

        System.out.print("Service Odometer: ");
        int odometer =
                Integer.parseInt(scanner.nextLine());

        ServiceRecord record = new ServiceRecord(
                0,
                reg,
                type,
                cost,
                odometer,
                LocalDate.now()
        );

        maintenanceService.addServiceRecord(record);

        System.out.println("Service record added!");
        System.out.println("Maintenance baseline updated!");
    }

    // 7. Cost audit
    private void costAudit() {

        List<Map<String, Object>> reports =
                auditService.getCostReport();

        System.out.println("\n---------- FLEET COST AUDIT ----------");

        for (Map<String, Object> row : reports) {

            System.out.println("--------------------------------");

            System.out.println("Vehicle: " +
                    row.get("reg_number"));

            System.out.println("Model: " +
                    row.get("model"));

            System.out.println("Fuel Cost: Rs. " +
                    row.get("total_fuel_cost"));

            System.out.println("Maintenance Cost: Rs. " +
                    row.get("total_service_cost"));

            System.out.println("Total Operational Cost: Rs. " +
                    row.get("total_operational_cost"));
        }
    }
}
