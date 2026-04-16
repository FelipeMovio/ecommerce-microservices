package com.felipe.ProductServer.dto;

import com.felipe.ProductServer.entity.Product;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotNull
        Double price,

        @NotNull
        Integer stock,

        @DecimalMin(value = "0.0", message = "A avaliação mínima é 0")
        @DecimalMax(value = "5.0", message = "A avaliação máxima é 5")
        BigDecimal assessment
) {
public Product toEntity(){
    return new Product(null,this.name, this.price, this.stock, this.assessment);
}
}
