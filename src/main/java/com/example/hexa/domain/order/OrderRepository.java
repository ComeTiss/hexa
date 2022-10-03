package com.example.hexa.domain.order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<Order> findById(UUID orderId);

    void save(Order order);
}
