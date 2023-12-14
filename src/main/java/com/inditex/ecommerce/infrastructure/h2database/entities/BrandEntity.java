package com.inditex.ecommerce.infrastructure.h2database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BRANDS")
public class BrandEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "BRAND_ID")
    private Long brandId;

    @Column (name = "BRAND_NAME")
    private String name;

}
