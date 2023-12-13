package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.Price;
import com.inditex.ecommerce.domain.PricesPort;
import com.inditex.ecommerce.infrastructure.ports.PriceRepositoryPort;

import java.time.LocalDate;
import java.util.List;

public class PricesFinder implements PricesPort {

    private final PriceRepositoryPort priceRepositoryPort;

    public PricesFinder(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public List<Price> search(Long brandId, Long productId, LocalDate applicationDate) {
        List<Price> prices = priceRepositoryPort.find(brandId, productId, applicationDate);

        //TODO Aqui debo seleccionar el de mayor prioridad.
        return null;
    }
}
