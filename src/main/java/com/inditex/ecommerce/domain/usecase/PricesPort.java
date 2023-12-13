package com.inditex.ecommerce.domain.usecase;

import com.inditex.ecommerce.domain.entities.Price;

import java.time.LocalDate;
import java.util.List;

public interface PricesPort {
    Price search(Long brandId, Long productId, LocalDate applicationDate);
}
