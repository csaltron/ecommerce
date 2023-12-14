package com.inditex.ecommerce.domain.usecase;

import com.inditex.ecommerce.domain.entities.Price;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PricesPort {
    Price search(Integer brandId, Integer productId, LocalDateTime applicationDate);
}
