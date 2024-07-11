package com.gabrielcarvalhotp.api.meumercado.dtos;

import java.util.UUID;

public record ProductDTO(
        String name,
        String description,
        String unit,
        Double weight,
        Double price,
        String urlImage,
        UUID establishmentsId,
        UUID productCategoryId
) { }
