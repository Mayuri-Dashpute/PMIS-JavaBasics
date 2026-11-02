package com.fleet.maintenance.model;


public record Vehicle(
        String regNumber,
        String model,
        int currentOdometer,
        int lastServiceOdometer,
        String status
) {
}