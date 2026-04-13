package com.felipe.ProductServer.dto;

import com.felipe.ProductServer.entity.Product;

public record ProductResponseMiniDTO(
      String name,
      Double price
) {
    public ProductResponseMiniDTO(Product p) {
        this(p.getName(),
                p.getPrice());
    }
}
