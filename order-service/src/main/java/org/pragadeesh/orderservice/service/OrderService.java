package org.pragadeesh.orderservice.service;

import org.pragadeesh.orderservice.client.ProductClient;
import org.pragadeesh.orderservice.model.Order;
import org.pragadeesh.orderservice.repository.OrderRepository;
import org.pragadeesh.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order addOrder(Order order) {
        Product product = productClient.getProductById(order.getProductId());
        if (product != null) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found!");
        }
    }
}
