package com.inditex.ecommerce.domain;

import java.time.LocalDate;
import java.util.List;

public interface PricesPort {
    List<Price> search(Long brandId, Long productId, LocalDate applicationDate);
}
