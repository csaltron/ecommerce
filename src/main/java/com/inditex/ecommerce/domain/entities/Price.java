package com.inditex.ecommerce.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Price {
    private Product product;
    private Brand brand;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double priceList;
    private Integer priority;
    private Double price;
    private String curr;
}
