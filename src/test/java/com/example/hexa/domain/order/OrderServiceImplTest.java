package com.example.hexa.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderServiceImplTest {

    private OrderRepository orderRepository;
    private OrderServiceImpl domainOrderService;

    @BeforeEach
    void setup() {
        orderRepository = mock(OrderRepository.class);
        domainOrderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    void should_create_order_then_save_it() {
        // GIVEN
        Product product = new Product(UUID.randomUUID(), BigDecimal.TEN);

        // WHEN
        UUID orderId = domainOrderService.createOrder(product);

        // THEN
        verify(orderRepository).save(any(Order.class));
        assertThat(orderId).isNotNull();
    }
}
