package com.inditex.ecommerce.infrastructure.adapters;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import com.inditex.ecommerce.infrastructure.h2database.repositories.PriceRepository;
import com.inditex.ecommerce.infrastructure.mapper.PriceMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryAdapter implements PriceRepositoryPort {



    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    public PriceRepositoryAdapter(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }


    @Override
    public List<Price> find(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        List<PriceEntity> priceEntity = priceRepository.find(brandId, productId, applicationDate);
        return priceMapper.toPrices(priceEntity);
    }

}
