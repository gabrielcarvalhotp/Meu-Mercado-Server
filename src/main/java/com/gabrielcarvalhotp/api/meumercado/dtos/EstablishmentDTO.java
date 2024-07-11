package com.gabrielcarvalhotp.api.meumercado.dtos;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;

public record EstablishmentDTO(
        String name,
        String address,
        String district,
        String city,
        String state,
        String cep,
        Double deliveryTax,
        Double minimumPurchase,
        String deliveryType
) {
}
