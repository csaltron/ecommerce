package com.inditex.ecommerce.infrastructure.h2database;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCTS")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    Long productId;

    @Column(name = "PRODUCT_NAME")
    String name;

    @Column(name = "PRODUCT_DESCRIPTION")
    String description;


}
