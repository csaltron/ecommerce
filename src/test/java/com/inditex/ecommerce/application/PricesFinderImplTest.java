package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.entities.Brand;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.entities.Product;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesFinderImplTest {
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
                .price(200.0)
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
                .price(200.0)
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
                .price(200.0)
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

}