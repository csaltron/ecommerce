package com.inditex.ecommerce.rest;

import com.inditex.ecommerce.application.PricesFinder;
import com.inditex.ecommerce.domain.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/prices")
public class PricesController {

    private PricesFinder pricesFinder;

    PricesController(final PricesFinder pricesFinder){
        this.pricesFinder = pricesFinder;
    }

    @RequestMapping(value = "/search/{brandId}/{productId}/{applicationDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Price> searchPrices(
            @PathVariable Long brandId,@PathVariable Long productId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mi:ss") LocalDate applicationDate
            ) {

        return pricesFinder.search(brandId, productId, applicationDate);


    }
}
