package com.inditex.ecommerce.infrastructure.ports;

import com.inditex.ecommerce.domain.Price;

import java.time.LocalDate;
import java.util.List;

public interface PriceRepositoryPort {
    public List<Price> find(Long brandId, Long productId, LocalDate applicationDate);
}
