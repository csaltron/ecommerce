package com.inditex.ecommerce.infrastructure.h2database;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "BRANDS")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "BRAND_ID")
    Long brandId;

    @Column (name = "BRAND_NAME")
    String name;

}
