package com.inditex.ecommerce.rest.controller;

import com.inditex.ecommerce.domain.entities.Price;
import com.inditex.ecommerce.domain.usecase.PricesPort;
import com.inditex.ecommerce.rest.dto.BrandDTO;
import com.inditex.ecommerce.rest.dto.PriceDTO;
import com.inditex.ecommerce.rest.dto.ProductDTO;
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


    public PricesController(final PricesPort pricesPort){
        this.pricesPort = pricesPort;
    }

    @GetMapping(path = "/prices")
    public ResponseEntity<PriceDTO> searchPrices(
            @RequestParam Integer brandId,
            @RequestParam Integer productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate
            ) {
        log.info("Test");
        Price price = pricesPort.search(brandId, productId, applicationDate);
        PriceDTO priceDTO = PriceDTO.builder()
                .price(price.getAmount())
                .brand(BrandDTO.builder()
                        .id(price.getBrand().getId())
                        .name(price.getProduct().getName())
                        .build())
                .product(ProductDTO.builder()
                        .id(price.getProduct().getId())
                        .name(price.getProduct().getName())
                        .build())
                .curr(price.getCurr())
                .priority(price.getPriority())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate().toLocalDate())
                .endDate(price.getEndDate().toLocalDate())
                .build();



        return ResponseEntity.ok().body(priceDTO);


    }
}
