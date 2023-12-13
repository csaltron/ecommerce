package com.inditex.ecommerce.application;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.exceptions.PriceNotFoundException;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import com.inditex.ecommerce.domain.repositories.PriceRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * The type Prices finder.
 */
@Component
public class PricesFinderImpl implements PricesPort {

    private final PriceRepositoryPort priceRepositoryPort;

    public PricesFinderImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Price search(Long brandId, Long productId, LocalDate applicationDate) {
        List<Price> prices = priceRepositoryPort.find(brandId, productId, applicationDate);

        //TODO Aqui debo seleccionar el de mayor prioridad.



        if(prices == null || prices.isEmpty()){
            throw new PriceNotFoundException("No data found");
        }

        prices.stream().collect(groupingBy(Function.identity(), TreeMap::new, toList()))
                .lastEntry()
                .getValue()
                .forEach(System.out::println);
        return null;
    }
}
