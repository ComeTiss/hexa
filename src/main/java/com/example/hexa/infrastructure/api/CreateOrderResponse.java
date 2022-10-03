package com.example.hexa.infrastructure.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderResponse {
    private UUID orderId;
}
