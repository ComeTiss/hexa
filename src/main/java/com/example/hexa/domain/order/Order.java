package com.example.hexa.domain.order;

import java.math.BigDecimal;
import java.util.*;

public class Order {

    private UUID id;
    private OrderStatus status;
    private List<OrderItem> items;
    private BigDecimal price;

    public Order (UUID id, Product product) {
        this.id = id;
        this.status = OrderStatus.CREATED;
        this.items = new ArrayList<>(Arrays.asList(new OrderItem(product)));
        this.price = product.getPrice();
    }

    public void addProduct(Product product) {
        items.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeProduct(UUID productId) {
        getOrderItemById(productId).ifPresent(itemToRemove -> {
            items.removeIf(item -> item.getProductId() == itemToRemove.getProductId());
            price = price.subtract(itemToRemove.getPrice());
        });
    }

    public void complete() {
        status = OrderStatus.COMPLETED;
    }

    private Optional<OrderItem> getOrderItemById(UUID productId) {
        return items
                .stream()
                .filter(orderItem -> orderItem.getProductId() == productId)
                .findAny();
    }

    public UUID getId() {
        return id;
    }
}
