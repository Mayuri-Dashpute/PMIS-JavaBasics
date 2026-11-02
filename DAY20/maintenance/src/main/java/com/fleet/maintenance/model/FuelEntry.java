package com.fleet.maintenance.model;



import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FuelEntry(
        int entryId,
        String regNumber,
        BigDecimal litres,
        BigDecimal cost,
        int odometerReading,
        LocalDateTime fuelDate
) {
}