package com.inditex.ecommerce.rest.mapper;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.rest.dto.BrandDTO;
import com.inditex.ecommerce.rest.dto.PriceDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceMapper {
    default PriceDTO toPriceDto(Price price){
        //TODO Completar campos
        return PriceDTO
                .builder()
                .price(price.getPrice())
                .brand(BrandDTO.builder().id(price.getBrand().getId()).build())
                .build();
    }
}
