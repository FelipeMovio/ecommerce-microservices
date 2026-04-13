package com.felipe.ProductServer.service;

import com.felipe.ProductServer.dto.ProductRequestDTO;
import com.felipe.ProductServer.dto.ProductResponseDTO;
import com.felipe.ProductServer.dto.ProductResponseMiniDTO;
import com.felipe.ProductServer.entity.Product;
import com.felipe.ProductServer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;

    // create
    public void create(ProductRequestDTO dto) {
        Product response = dto.toEntity();

        repository.save(response);
    }

    // ver lista
    public Page<ProductResponseMiniDTO> getList(Pageable pageable) {

        return repository.findAll(pageable)
                .map(ProductResponseMiniDTO::new);
    }

    // ver um
    public ProductResponseDTO getOne(Long id) {
        Product procurar = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        return new ProductResponseDTO(procurar);
    }


}
