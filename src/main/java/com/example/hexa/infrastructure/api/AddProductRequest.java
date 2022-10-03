package com.example.hexa.infrastructure.api;

import com.example.hexa.domain.order.Product;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AddProductRequest {
    private Product product;
}
