package com.github.destroyex.gestionpedidos.service;

import com.github.destroyex.gestionpedidos.dao.OrderRepository;
import com.github.destroyex.gestionpedidos.entity.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Order create(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.getOrderLines().forEach(orderLine -> orderLine.setOrder(order));
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        Order deletedOrder = findById(id);
        orderRepository.delete(deletedOrder);
    }

    public Order update(Long id, Order updatedOrder) {
        Order existingOrder = findById(id);
        updatedOrder.getOrderLines().forEach(orderLine -> orderLine.setOrder(existingOrder));
        existingOrder.setOrderLines(updatedOrder.getOrderLines());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setStatus(updatedOrder.getStatus());
        return orderRepository.save(existingOrder);

    }

}
