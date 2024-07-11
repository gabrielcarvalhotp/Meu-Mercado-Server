package com.gabrielcarvalhotp.api.meumercado.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

public record StandardException(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'", timezone = "GMT")
        LocalDateTime timestamp,
        int status,
        String error,
        String message
) {
}
