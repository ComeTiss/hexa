package com.example.hexa.infrastructure.api;

import com.example.hexa.domain.order.Product;
import lombok.Getter;

@Getter
public class CreateOrderRequest {
    private Product product;
}
