package com.inditex.ecommerce.infrastructure.h2database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    Long productId;

    @Column(name = "PRODUCT_NAME")
    String name;

    @Column(name = "PRODUCT_DESCRIPTION")
    String description;


}
