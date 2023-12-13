package com.inditex.ecommerce.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

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
