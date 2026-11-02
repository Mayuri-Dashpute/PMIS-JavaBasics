package com.fleet.maintenance.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ServiceRecord(
        int serviceId,
        String regNumber,
        String serviceType,
        BigDecimal serviceCost,
        int serviceOdometer,
        LocalDate serviceDate
) {
}