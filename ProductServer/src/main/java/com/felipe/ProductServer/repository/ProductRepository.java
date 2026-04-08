package com.felipe.ProductServer.repository;

import com.felipe.ProductServer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
