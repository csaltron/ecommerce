package com.inditex.ecommerce.domain.repositories;

import com.inditex.ecommerce.domain.entities.Price;

import java.time.LocalDate;
import java.util.List;

public interface PriceRepositoryPort {
    public List<Price> find(Long brandId, Long productId, LocalDate applicationDate);
}
