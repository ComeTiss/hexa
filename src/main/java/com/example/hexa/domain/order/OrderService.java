package com.example.hexa.domain.order;

import java.util.UUID;

public interface OrderService {

    UUID createOrder(Product product);

    void completeOrder(UUID orderId);

    Order getById(UUID orderId);

    void addProduct(UUID orderId, Product product);

    void deleteProduct(UUID orderId, UUID productId);
}
