package com.felipe.ProductServer.dto;

import com.felipe.ProductServer.entity.Product;

import java.math.BigDecimal;

public record ProductResponseMiniDTO(
       Long id,
      String name,
      Double price,
      BigDecimal assessment
) {
    public ProductResponseMiniDTO(Product p) {
        this(p.getId(),
                p.getName(),
                p.getPrice(),
                p.getAssessment());
    }
}
