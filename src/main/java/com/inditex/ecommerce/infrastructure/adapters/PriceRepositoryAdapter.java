package com.inditex.ecommerce.infrastructure.adapters;

import com.inditex.ecommerce.domain.entities.Brand;
import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.entities.Product;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import com.inditex.ecommerce.infrastructure.h2database.repositories.PriceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PriceRepositoryAdapter implements PriceRepositoryPort {



    private final PriceRepository priceRepository;

    public PriceRepositoryAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    public List<Price> find(Long brandId, Long productId, LocalDate applicationDate) {
        List<PriceEntity> priceEntity = priceRepository.find(brandId, productId, applicationDate);
        return toPriceList(priceEntity);

    }

    private List<Price> toPriceList(@NotNull List<PriceEntity> priceEntity) {
        return priceEntity.stream()
                .map(pricesEntity -> Price.builder()
                        .product(Product.builder()
                                .id(pricesEntity.getProductId())
//                                .name(pricesEntity.getProductEntity().getName())
//                                .description(pricesEntity.getProductEntity().getDescription())
                                .build())
                        .brand(Brand.builder()
                                .id(pricesEntity.getBrandId())
//                                .name(pricesEntity.getBrandEntity().getName())
                                .build())
                        .startDate(pricesEntity.getStartDate())
                        .endDate(pricesEntity.getEndDate())
                        .priceList(pricesEntity.getPriceList())
                        .price(pricesEntity.getPrice())
                        .priority(pricesEntity.getPriority())
                        .curr(pricesEntity.getCurr())
                        .build())
                .collect(Collectors.toList());
    }
}
