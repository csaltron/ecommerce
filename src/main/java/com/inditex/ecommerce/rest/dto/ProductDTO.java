package com.inditex.ecommerce.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
}
