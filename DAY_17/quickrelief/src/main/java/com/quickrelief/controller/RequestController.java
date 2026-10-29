package com.quickrelief.controller;

import com.quickrelief.model.RequestInput;
import com.quickrelief.model.SupplyRequest;
import com.quickrelief.service.SupplyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    private final SupplyService supplyService;

    public RequestController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplyRequest createRequest(@Valid @RequestBody RequestInput input) {
        return supplyService.allocateSupply(input);
    }
}
