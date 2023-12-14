package com.inditex.ecommerce.domain.usecase;

import com.inditex.ecommerce.domain.entities.Price;

import java.time.LocalDateTime;

public interface PricesPort {
    Price search(Integer brandId, Integer productId, LocalDateTime applicationDate);
}
