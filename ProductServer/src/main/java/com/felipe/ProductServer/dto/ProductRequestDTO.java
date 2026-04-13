package com.felipe.ProductServer.dto;

import com.felipe.ProductServer.entity.Product;
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
public Product toEntity(){
    return new Product(null,this.name, this.price, this.stock);
}
}
