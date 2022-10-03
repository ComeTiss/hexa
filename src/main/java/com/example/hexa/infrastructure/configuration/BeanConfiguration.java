package com.example.hexa.infrastructure.configuration;

import com.example.hexa.domain.order.OrderRepository;
import com.example.hexa.domain.order.OrderService;
import com.example.hexa.domain.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }
}
