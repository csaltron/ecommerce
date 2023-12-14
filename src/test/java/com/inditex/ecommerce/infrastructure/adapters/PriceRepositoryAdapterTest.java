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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryAdapterTest {

    @InjectMocks
    private PriceRepositoryAdapter priceRepositoryAdapter;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void findWhenQueryValidValuesExpectedListPrices(){
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime currentDate = LocalDateTime.of(2020, 7, 1, 0, 0);

        PriceEntity price = new PriceEntity();
        price.setBrandId((1L));
        price.setPriceId(1L);
        price.setPriceList(1D);
        price.setCurr("EUR");
        price.setPrice(200.0);
        price.setPriority(0);
        price.setProductId(35455L);
        price.setStartDate(LocalDateTime.of(2020, 1, 1, 0, 0));
        price.setEndDate(LocalDateTime.of(2020, 12, 1, 0, 0));


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
                .amount(200.0)
                .priority(0)
                .startDate(LocalDateTime.of(2020, 1, 1, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 1, 0, 0)).build();
        expectedResponse.add(priceExpected);

        // Test
        List<Price> pricesList = priceRepositoryAdapter.find(brandId, productId, currentDate);
        assertEquals(expectedResponse, pricesList);
    }

}
