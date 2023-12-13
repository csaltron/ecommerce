package com.inditex.ecommerce.infrastructure.adapters;

import com.inditex.ecommerce.domain.entities.Brand;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.entities.Product;
import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import com.inditex.ecommerce.infrastructure.h2database.repositories.PriceRepository;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final static Logger LOGGER = LoggerFactory.getLogger(PriceRepositoryAdapter.class);

    private final PriceRepository priceRepository;

    public PriceRepositoryAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    public List<Price> find(Long brandId, Long productId, LocalDate applicationDate) {
        List<PriceEntity> priceEntity = priceRepository.find(brandId, productId, applicationDate);
        return toPriceList(priceEntity);

    }

    private List<Price> toPriceList(List<PriceEntity> priceEntity) {
        List<Price> pricesList = priceEntity.stream()
                .map(pricesEntity -> Price.builder()
                        .product(Product.builder()
                                .id(pricesEntity.getProductEntity().getProductId())
                                .name(pricesEntity.getProductEntity().getName())
                                .description(pricesEntity.getProductEntity().getDescription())
                                .build())
                        .brand(Brand.builder()
                                .id(pricesEntity.getBrandEntity().getBrandId())
                                .name(pricesEntity.getBrandEntity().getName())
                                .build())
                        .startDate(pricesEntity.getStartDate())
                        .endDate(pricesEntity.getEndDate())
                        .priceList(pricesEntity.getPriceList())
                        .price(pricesEntity.getPrice())
                        .priority(pricesEntity.getPriority())
                        .curr(pricesEntity.getCurr())
                        .build())
                .collect(Collectors.toList());
        return pricesList;
    }
}
