package com.inditex.ecommerce.rest.controller;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import com.inditex.ecommerce.rest.dto.PriceDTO;
import com.inditex.ecommerce.rest.mapper.PriceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class PricesController {

    private final PricesPort pricesPort;


    private final PriceMapper priceMapper;

    public PricesController(final PricesPort pricesPort, PriceMapper priceMapper){
        this.pricesPort = pricesPort;
        this.priceMapper = priceMapper;
    }

    @GetMapping(path = "/prices")
    public ResponseEntity<PriceDTO> searchPrices(
            @RequestParam Integer brandId,
            @RequestParam Integer productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate
            ) {
        log.info("Test");
        Price price = pricesPort.search(brandId, productId, applicationDate);
        PriceDTO priceDTO = priceMapper.toPriceDto(price);

        return ResponseEntity.ok().body(priceDTO);


    }
}
