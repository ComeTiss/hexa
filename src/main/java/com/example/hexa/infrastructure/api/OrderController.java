package com.example.hexa.infrastructure.api;

import com.example.hexa.domain.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        UUID orderId = orderService.createOrder(request.getProduct());
        return new CreateOrderResponse(orderId);
    }

    @PostMapping(value = "/{orderId}/complete")
    void completeOrder(@PathVariable UUID orderId) {
        orderService.completeOrder(orderId);
    }

    @PostMapping(value = "/{orderId}/product")
    void addProduct(@PathVariable UUID orderId, @RequestBody AddProductRequest request) {
        orderService.addProduct(orderId, request.getProduct());
    }

    @PostMapping(value = "/{id}/product")
    void deleteProduct(@PathVariable UUID orderId, @RequestParam UUID productId) {
        orderService.deleteProduct(orderId, productId);
    }
}
