package com.inditex.ecommerce.rest.controller;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import com.inditex.ecommerce.rest.dto.PriceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping(value = "/prices")
public class PricesController {

    private final PricesPort pricesPort;

    public PricesController(final PricesPort pricesPort){
        this.pricesPort = pricesPort;
    }

    @GetMapping(path = "/search/{brandId}/{productId}/{applicationDate}")
    public ResponseEntity<PriceDTO> searchPrices(
            @PathVariable Integer brandId,
            @PathVariable Integer productId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate applicationDate
            ) {
        log.info("Test");
        Price price = pricesPort.search(brandId, productId, applicationDate);
        PriceDTO priceDTO = PriceDTO.builder().price(price.getPrice()).build();
        return ResponseEntity.ok().body(priceDTO);


    }
}
