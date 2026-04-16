package com.felipe.ProductServer.service;

import com.felipe.ProductServer.dto.ProductResponseDTO;
import com.felipe.ProductServer.dto.ProductResponseMiniDTO;
import com.felipe.ProductServer.entity.Product;
import com.felipe.ProductServer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterProductsService {

    private final ProductRepository repository;

    // melhores avaliados
    public List<ProductResponseMiniDTO> melhores(){
        return repository.findAll()
                .stream()
                .filter(p -> p.getAssessment() != null &&
                        p.getAssessment().compareTo(new BigDecimal("3.5")) >= 0)
                .sorted(Comparator.comparing(Product::getAssessment).reversed())
                .map(ProductResponseMiniDTO::new)
                .collect(Collectors.toList());

    }

    // melhores e mias baratos
    public  List<ProductResponseMiniDTO> melhoresAndBaratos(){

        return melhores().stream()
                .sorted(Comparator.comparing(ProductResponseMiniDTO::price)) // mais baratos primeiro
                .limit(10) // opcional (top 10)
                .collect(Collectors.toList());
    }

    // media das avaliacoes
    public Double media(){
        DoubleSummaryStatistics stats = repository.findAll().stream()
                .filter(p -> p.getAssessment() != null)
                .mapToDouble(p -> p.getAssessment().doubleValue())
                .summaryStatistics();

        return stats.getCount() > 0 ? stats.getAverage() : null;
    }
}
