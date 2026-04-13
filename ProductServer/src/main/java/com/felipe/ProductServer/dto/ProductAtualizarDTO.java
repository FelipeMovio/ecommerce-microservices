package com.felipe.ProductServer.dto;

public record ProductAtualizarDTO(
        String name,
        Double price,
        Integer stock
) {
}
