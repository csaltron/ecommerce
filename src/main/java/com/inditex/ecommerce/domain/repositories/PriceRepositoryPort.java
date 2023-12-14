package com.inditex.ecommerce.domain.repositories;

import com.inditex.ecommerce.domain.entities.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
    public List<Price> find(Integer brandId, Integer productId, LocalDateTime applicationDate);
}
