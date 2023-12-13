package com.inditex.ecommerce.infrastructure.h2database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRICES")
public class PriceEntity {

    @Id
    @Column(name = "PRICE_ID")
    private Long priceId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "PRICE_LIST")
    private Double priceList;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String curr;



}
