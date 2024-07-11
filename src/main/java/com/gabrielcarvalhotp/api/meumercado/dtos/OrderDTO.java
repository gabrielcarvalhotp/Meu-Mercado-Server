package com.gabrielcarvalhotp.api.meumercado.dtos;

import com.gabrielcarvalhotp.api.meumercado.domains.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record OrderDTO(
        Double subtotal,
        Double deliveryTax,
        Double total,
        String address,
        String district,
        String city,
        String state,
        String cep,
        UUID userId,
        UUID establishmentId,
        List<OrderItemDTO> orderItems
) {
}