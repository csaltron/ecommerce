package com.inditex.ecommerce.infrastructure.h2database;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICES")
public class PriceEntity implements Serializable {

    private ProductEntity productEntity;
    private BrandEntity brandEntity;

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
