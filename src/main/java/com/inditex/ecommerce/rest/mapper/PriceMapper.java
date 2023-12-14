package com.inditex.ecommerce.rest.mapper;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.rest.dto.BrandDTO;
import com.inditex.ecommerce.rest.dto.PriceDTO;
import com.inditex.ecommerce.rest.dto.ProductDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceMapper {
    default PriceDTO toPriceDto(Price price){
                return PriceDTO.builder()
                .price(price.getAmount())
                .brand(BrandDTO.builder()
                        .id(price.getBrand().getId())
                        .name(price.getProduct().getName())
                        .build())
                .product(ProductDTO.builder()
                        .id(price.getProduct().getId())
                        .name(price.getProduct().getName())
                        .build())
                .curr(price.getCurr())
                .priority(price.getPriority())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate().toLocalDate())
                .endDate(price.getEndDate().toLocalDate())
                .build();
    }
}
