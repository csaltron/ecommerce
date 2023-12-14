package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.entities.Brand;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.entities.Product;
import com.inditex.ecommerce.domain.exceptions.PriceNotFoundException;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesFinderImplTest {
    @InjectMocks
    private PricesFinderImpl pricesFinder;

    @Mock
    private PriceRepositoryPort priceRepositoryPort;


    @Test
    void whenPricesFinderSearch(){
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime currentDate = LocalDateTime.of(2020, 01, 01, 0, 0);
        List<Price> prices = new ArrayList<>();
        Price price1 = Price.builder()
                        .brand(Brand.builder()
                                .id(1L).build())
                .priceId(1L)
                .priceList(1D)
                .curr("EUR")
                .amount(200.0)
                .priority(1)
                .product(Product.builder()
                        .id(35455L)
                        .build())
                .startDate(LocalDateTime.of(2020, 01, 01, 0, 0))
                .endDate(LocalDateTime.of(2020, 01, 01, 0, 0)).build();

        Price price2 = Price.builder()
                .brand(Brand.builder()
                        .id(1L).build())
                .priceId(1L)
                .priceList(1D)
                .curr("EUR")
                .amount(200.0)
                .priority(2)
                .product(Product.builder()
                        .id(35455L)
                        .build())
                .startDate(LocalDateTime.of(2020, 01, 01, 0, 0))
                .endDate(LocalDateTime.of(2020, 01, 01, 0, 0)).build();

        Price priceResult = Price.builder()
                .brand(Brand.builder()
                        .id(1L).build())
                .priceId(1L)
                .priceList(1D)
                .curr("EUR")
                .amount(200.0)
                .priority(2)
                .product(Product.builder()
                        .id(35455L)
                        .build())
                .startDate(LocalDateTime.of(2020, 01, 01, 0, 0))
                .endDate(LocalDateTime.of(2020, 01, 01, 0, 0)).build();

        prices.add(price1);
        prices.add(price2);


        when(priceRepositoryPort
                .find(brandId,productId,currentDate))
                .thenReturn(prices);


        Price pricePriority = pricesFinder.search(brandId, productId, currentDate);


        assertEquals(priceResult, pricePriority);


    }

    @Test
    void whenPricesNotFound(){
        Integer brandId = 1;
        Integer productId = 9999;
        LocalDateTime currentDate = LocalDateTime.of(1900, 01, 01, 0, 0);
        List<Price> prices = new ArrayList<>();

        when(priceRepositoryPort
                .find(brandId,productId,currentDate))
                .thenReturn(prices);

        assertThrows(PriceNotFoundException.class, () -> {
            pricesFinder.search(brandId, productId, currentDate);
        });

    }

}
