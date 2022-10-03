package com.example.hexa.domain.order;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private UUID id;
    private BigDecimal price;

    public Product(UUID id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public UUID getId() {
        return id;
    }
}
