package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * The type Prices finder.
 */
@Slf4j
@Component
public class PricesFinderImpl implements PricesPort {

    private final PriceRepositoryPort priceRepositoryPort;

    public PricesFinderImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Price search(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepositoryPort.find(brandId, productId, applicationDate);
        for (Price price : prices) {
            log.info (String.valueOf(price));
        }
        Optional<Price> first = prices.stream()
                .max(Comparator.comparing(Price::getPriority));
        if(first.isPresent()){
            log.info ("el precio actual es: " + first.get());
            return first.get();
        }
        return Price.builder().build();


    }
}
