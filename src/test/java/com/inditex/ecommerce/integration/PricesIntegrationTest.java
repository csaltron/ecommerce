package com.inditex.ecommerce.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class PricesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    //Test 1
    @Test
    void test1WhenDay14AndHour10Product35455BrandId1ExpectsPrice() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00")
                        .contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("price").value(35.50))
                .andExpect(jsonPath("brand.id").value(1));
    }

    //Test 2
    @Test
    void test2WhenDay14AndHour16Product35455BrandId1ExpectsPrice() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00")
                        .contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("price").value(25.45))
                .andExpect(jsonPath("brand.id").value(1));
    }

    //Test 3
    @Test
    void test3WhenDay14AndHour21Product35455BrandId1ExpectsPrice() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices?brandId=1&productId=35455&applicationDate=2020-06-14T21:00:00")
                        .contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("price").value(35.50))
                .andExpect(jsonPath("brand.id").value(1));
    }

    //Test 4
    @Test
    void test4WhenDay15AndHour10Product35455BrandId1ExpectsPrice() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices?brandId=1&productId=35455&applicationDate=2020-06-15T10:00:00")
                        .contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("price").value(30.50))
                .andExpect(jsonPath("brand.id").value(1));
    }

    //Test 5
    @Test
    void test5WhenDay15AndHour21Product35455BrandId1ExpectsPrice() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices?brandId=1&productId=35455&applicationDate=2020-06-15T21:00:00")
                        .contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("price").value(38.95))
                .andExpect(jsonPath("brand.id").value(1));
    }
}
