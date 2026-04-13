package com.felipe.ProductServer.dto;

import com.felipe.ProductServer.entity.Product;

public record ProductResponseMiniDTO(
       Long id,
      String name,
      Double price
) {
    public ProductResponseMiniDTO(Product p) {
        this(p.getId(),
                p.getName(),
                p.getPrice());
    }
}
