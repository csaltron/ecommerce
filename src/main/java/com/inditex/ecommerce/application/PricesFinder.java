package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.Price;
import com.inditex.ecommerce.domain.PricesPort;
import com.inditex.ecommerce.infrastructure.h2database.PriceRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class PricesFinder implements PricesPort {

    @Autowired //TODO eliminar inyeccion de dependencia de esta forma
    PriceRepositoryPort priceRepositoryPort;


    @Override
    public List<Price> search(Long brandId, Long productId, LocalDate applicationDate) {
        List<Price> prices = priceRepositoryPort.find(brandId, productId, applicationDate);

        //TODO Aqui debo seleccionar el de mayor prioridad.
        return null;
    }
}
