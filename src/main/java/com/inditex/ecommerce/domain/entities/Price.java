package com.inditex.ecommerce.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Price {
    private Long priceId;
    private Product product;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double priceList;
    private Integer priority;
    private Double amount;
    private String curr;
}
