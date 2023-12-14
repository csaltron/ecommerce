package com.inditex.ecommerce.infrastructure.adapters;

import com.inditex.ecommerce.domain.entities.Brand;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.entities.Product;
import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import com.inditex.ecommerce.infrastructure.h2database.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceRepositoryAdapterTest {

    @InjectMocks
    private PriceRepositoryAdapter priceRepositoryAdapter;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void findWhenQueryValidValuesExpectedListPrices(){
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime currentDate = LocalDateTime.parse("2020-07-01");

        PriceEntity price = new PriceEntity();
        price.setBrandId((1L));
        price.setPriceId(1L);
        price.setPriceList(1D);
        price.setCurr("EUR");
        price.setPrice(200.0);
        price.setPriority(0);
        price.setProductId(35455L);
        price.setStartDate(LocalDateTime.parse("2020-01-01"));
        price.setEndDate(LocalDateTime.parse("2020-12-31"));


        List<PriceEntity> pricesEntities = List.of(price);

        when(priceRepository
                .find(brandId, productId, currentDate))
                .thenReturn(pricesEntities);

        List<Price> expectedResponse = new ArrayList<>();
        Price priceExpected = Price.builder()
                .priceId(1L)
                .priceList(1D)
                .brand(Brand.builder()
                        .id(1L).build())
                .product(Product.builder()
                        .id(35455L)
                .build())
                .curr("EUR")
                .price(200.0)
                .priority(0)
                .startDate(LocalDateTime.parse("2020-01-01"))
                .endDate(LocalDateTime.parse("2020-12-31")).build();
        expectedResponse.add(priceExpected);

        // Test
        List<Price> pricesList = priceRepositoryAdapter.find(brandId, productId, currentDate);
        assertEquals(expectedResponse, pricesList);
    }

}
