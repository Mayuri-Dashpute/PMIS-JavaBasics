package com.quickrelief.controller;

import com.quickrelief.model.Supply;
import com.quickrelief.model.SupplyInput;
import com.quickrelief.service.SupplyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {
    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supply addOrRestock(@Valid @RequestBody SupplyInput input) {
        return supplyService.addOrRestock(input);
    }

    @GetMapping
    public List<Supply> getAllSupplies() {
        return supplyService.getAllSupplies();
    }
}
