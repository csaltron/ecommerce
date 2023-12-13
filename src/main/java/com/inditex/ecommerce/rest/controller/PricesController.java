package com.inditex.ecommerce.rest.controller;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import com.inditex.ecommerce.rest.dto.PriceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping(value = "/prices")
public class PricesController {

    private final PricesPort pricesPort;

    public PricesController(final PricesPort pricesPort){
        this.pricesPort = pricesPort;
    }

    @RequestMapping(value = "/search/{brandId}/{productId}/{applicationDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> searchPrices(
            @PathVariable Long brandId,@PathVariable Long productId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh24:mi:ss") LocalDate applicationDate
            ) {
        log.info("Test");
        Price price = pricesPort.search(brandId, productId, applicationDate);
        PriceDTO priceDTO = PriceDTO.builder().price(price.getPrice()).build();
        return ResponseEntity.ok().body(priceDTO);


    }
}
