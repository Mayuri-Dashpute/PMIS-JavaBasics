package com.quickrelief.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class SupplyInput {
    @NotBlank(message = "itemName is required")
    private String itemName;

    @Positive(message = "quantity must be greater than zero")
    private int quantity;

    public SupplyInput() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
