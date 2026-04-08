package com.felipe.ProductServer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotNull
        Double price,

        @NotNull
        Integer stock
) {
}
