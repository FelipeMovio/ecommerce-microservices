package com.felipe.ProductServer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Double price;
    private Integer stock;

    @Column(columnDefinition = "DECIMAL(2,1) CHECK (assessment >= 0 AND assessment <= 5)")
    private BigDecimal assessment;

}
