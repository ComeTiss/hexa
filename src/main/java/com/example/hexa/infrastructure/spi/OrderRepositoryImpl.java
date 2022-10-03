package com.example.hexa.infrastructure.spi;

import com.example.hexa.domain.order.Order;
import com.example.hexa.domain.order.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Optional<Order> findById(UUID orderId) {
        return Optional.empty();
    }

    @Override
    public void save(Order order) {

    }
}
