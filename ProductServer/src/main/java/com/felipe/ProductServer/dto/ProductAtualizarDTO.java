package com.felipe.ProductServer.dto;

import java.math.BigDecimal;

public record ProductAtualizarDTO(
        String name,
        Double price,
        Integer stock,
        BigDecimal assessment
) {
}
