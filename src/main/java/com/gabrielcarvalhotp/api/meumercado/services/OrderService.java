package com.gabrielcarvalhotp.api.meumercado.services;

import com.gabrielcarvalhotp.api.meumercado.domains.Order;
import com.gabrielcarvalhotp.api.meumercado.domains.OrderItem;
import com.gabrielcarvalhotp.api.meumercado.dtos.OrderDTO;
import com.gabrielcarvalhotp.api.meumercado.dtos.OrderItemDTO;
import com.gabrielcarvalhotp.api.meumercado.repositories.OrderRepository;
import com.gabrielcarvalhotp.api.meumercado.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EstablishmentService establishmentService;

    @Autowired
    private ProductService productService;

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO);
        order.setUser(userService.getUserById(orderDTO.userId()));
        order.setEstablishment(establishmentService.getEstablishmentById(orderDTO.establishmentId()));

        for (OrderItemDTO orderItemDTO : orderDTO.orderItems()) {
            OrderItem orderItem = new OrderItem(orderItemDTO);
            orderItem.setOrder(order);
            orderItem.setProduct(productService.getProductById(orderItemDTO.productId()));
            order.getOrderItems().add(orderItem);
        }
        orderRepository.save(order);
        return order;
    }

    public List<Order> getOrdersByUserId(UUID userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
}
