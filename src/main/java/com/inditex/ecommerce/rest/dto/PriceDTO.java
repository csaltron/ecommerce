package com.inditex.ecommerce.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class PriceDTO {
    private ProductDTO product;
    private BrandDTO brand;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double priceList;
    private Integer priority;
    private Double price;
    private String curr;
}
