package com.example.hexa.domain.order;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(Product product) {
        Order newOrder = new Order(UUID.randomUUID(), product);
        orderRepository.save(newOrder);
        return newOrder.getId();
    }

    @Override
    public void completeOrder(UUID orderId) {
        Order order = getOrder(orderId);
        order.complete();
        orderRepository.save(order);
    }

    @Override
    public Order getById(UUID orderId) {
        return getOrder(orderId);
    }

    @Override
    public void addProduct(UUID orderId, Product product) {
        Order existingOrder = getOrder(orderId);
        existingOrder.addProduct(product);
        orderRepository.save(existingOrder);
    }

    @Override
    public void deleteProduct(UUID orderId, UUID productId) {
        Order existingOrder = getOrder(orderId);
        existingOrder.removeProduct(productId);
        orderRepository.save(existingOrder);
    }

    private Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow();
    }
}
