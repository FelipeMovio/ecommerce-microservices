package com.felipe.ProductServer.dto;

import com.felipe.ProductServer.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductResponseDTO(

        Long id,

        String name,

        Double price,

        Integer stock
) {
    public ProductResponseDTO(Product p) {
        this(p.getId(),
                p.getName(),
                p.getPrice(),
                p.getStock());
    }
}
