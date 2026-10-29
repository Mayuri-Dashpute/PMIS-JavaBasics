package com.quickrelief.service;

import com.quickrelief.model.Supply;
import com.quickrelief.model.SupplyInput;
import com.quickrelief.model.RequestInput;
import com.quickrelief.model.SupplyRequest;
import com.quickrelief.repository.RequestRepository;
import com.quickrelief.repository.SupplyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final RequestRepository requestRepository;

    public SupplyService(SupplyRepository supplyRepository,
                         RequestRepository requestRepository) {
        this.supplyRepository = supplyRepository;
        this.requestRepository = requestRepository;
    }

    public Supply addOrRestock(SupplyInput input) {
        String itemName = input.getItemName().trim();
        return supplyRepository.addOrRestock(itemName, input.getQuantity());
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    @Transactional
    public SupplyRequest allocateSupply(RequestInput input) {
        String itemName = input.getItemName().trim();
        String requestedBy = input.getRequestedBy().trim();
        int quantity = input.getQuantity();

        // First check whether the requested item exists.
        if (supplyRepository.findByItemName(itemName).isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Supply item not found: " + itemName);
        }

        // Atomic conditional update prevents stock from becoming negative.
        int rowsUpdated = supplyRepository.deductStock(itemName, quantity);

        if (rowsUpdated == 0) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Insufficient stock for: " + itemName);
        }

        // If saving the request fails, @Transactional rolls back the stock deduction.
        return requestRepository.save(itemName, quantity, "APPROVED", requestedBy);
    }
}
