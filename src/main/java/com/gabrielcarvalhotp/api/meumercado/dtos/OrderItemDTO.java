package com.gabrielcarvalhotp.api.meumercado.dtos;

import lombok.Setter;

import java.util.UUID;

public record OrderItemDTO(
        Double price,
        Integer quantity,
        UUID productId
) { }