package com.felipe.ProductServer.repository;

import com.felipe.ProductServer.entity.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByName(String name);


    List<Product> findAllByName(String name);
}
