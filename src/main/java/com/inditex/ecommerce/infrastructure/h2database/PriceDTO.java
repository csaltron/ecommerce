package com.inditex.ecommerce.infrastructure.h2database;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter
//TODO NO SE ESTÁ USANDO, ELIMINAR LUEGO
public final class PriceDTO {
    private Long productId;
    private Long brandId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double priceList;
    private Integer priority;
    private Double price;
    private String curr;
}
