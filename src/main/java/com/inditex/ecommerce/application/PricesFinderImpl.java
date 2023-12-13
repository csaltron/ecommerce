package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.Price;
import com.inditex.ecommerce.domain.PricesPort;
import com.inditex.ecommerce.infrastructure.ports.PriceRepositoryPort;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class PricesFinder implements PricesPort {

    private final PriceRepositoryPort priceRepositoryPort;

    public PricesFinder(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public List<Price> search(Long brandId, Long productId, LocalDate applicationDate) {
        List<Price> prices = priceRepositoryPort.find(brandId, productId, applicationDate);

        //TODO Aqui debo seleccionar el de mayor prioridad.

        prices.stream(). collect(groupingBy(Function.identity(), TreeMap::new, toList()))
                .lastEntry()
                .getValue()
                .forEach(System.out::println);


        return null;
    }
}
