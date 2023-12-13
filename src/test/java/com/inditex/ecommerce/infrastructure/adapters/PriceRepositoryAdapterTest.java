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
        Integer productId = 1;
        LocalDate currentDate = LocalDate.parse("2020-12-13");

        PriceEntity price = new PriceEntity();
        price.setPrice(200.0);
        price.setBrandId((1L));
        price.setPriceId(411L);
        List<PriceEntity> pricesEntities = List.of(price);

        when(this.priceRepository.find(brandId, productId, currentDate)).thenReturn(pricesEntities);

        List<Price> expectedResponse = new ArrayList<>();
        Price priceExpected = Price.builder().brand(Brand.builder().id(1L).build()).product(Product.builder()
                .build()).price(200.0).build();
        expectedResponse.add(priceExpected);

        // Test
        List<Price> pricesList = priceRepositoryAdapter.find(brandId, productId, currentDate);


        assertEquals(expectedResponse, pricesList);
    }

}
