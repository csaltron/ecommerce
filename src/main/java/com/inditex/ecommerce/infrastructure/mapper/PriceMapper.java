package com.inditex.ecommerce.infrastructure.mapper;

import com.inditex.ecommerce.domain.entities.Brand;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.entities.Product;
import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceMapper {

    default List<Price> toPrices(List<PriceEntity> priceEntity) {
        List<Price> listPrices = new ArrayList();
        if (priceEntity != null && !priceEntity.isEmpty()) {
            listPrices = priceEntity.stream()
                    .map(pricesEntity -> Price.builder()
                            .priceId(pricesEntity.getPriceId())
                            .product(Product.builder()
                                    .id(pricesEntity.getProductId())
                                    .build())
                            .brand(Brand.builder()
                                    .id(pricesEntity.getBrandId())
                                    .build())
                            .startDate(pricesEntity.getStartDate())
                            .endDate(pricesEntity.getEndDate())
                            .priceList(pricesEntity.getPriceList())
                            .amount(pricesEntity.getPrice())
                            .priority(pricesEntity.getPriority())
                            .curr(pricesEntity.getCurr())
                            .build())
                    .toList();
        }
        return listPrices;
    }
}
