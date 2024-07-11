package com.gabrielcarvalhotp.api.meumercado.controllers;

import com.gabrielcarvalhotp.api.meumercado.domains.Order;
import com.gabrielcarvalhotp.api.meumercado.dtos.OrderDTO;
import com.gabrielcarvalhotp.api.meumercado.helpers.URIHelpers;
import com.gabrielcarvalhotp.api.meumercado.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.createOrder(orderDTO);
        URI uri = URIHelpers.servletUri("/orders/{id}", order.getId());
        return ResponseEntity.created(uri).body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrdersByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok().body(orderService.getOrdersByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

}
