package com.gabrielcarvalhotp.api.meumercado.dtos;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDTO(
        String name,
        String email,
        String password,
        String address,
        String district,
        String city,
        String state,
        String cep
) {
}
