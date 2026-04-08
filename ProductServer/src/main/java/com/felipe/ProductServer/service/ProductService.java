package com.felipe.ProductServer.service;

import com.felipe.ProductServer.dto.ProductRequestDTO;
import com.felipe.ProductServer.entity.Product;
import com.felipe.ProductServer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;

    // create
    public void create(ProductRequestDTO dto){
        Product response = new Product(null, dto.name(), dto.price(), dto.stock());

        repository.save(response);
    }

}
