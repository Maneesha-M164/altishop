package com.altimetrik.altishop.controller;

import com.altimetrik.altishop.model.Product;
import com.altimetrik.altishop.service.ProductService;
import com.altimetrik.altishop.service.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void addProduct() throws Exception {
        String date1="16-12-2024";
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

        Product p1 = Product.builder().productId(100).productName("Heater").productDoe(sdf.parse(date1)).productCost(500).build();
        Mockito.when(productService.addProduct(p1)).thenReturn(p1);
        mockMvc.perform(post("/product-api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(p1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(100));

    }

    @Test
    void getAllProducts() throws Exception {
        Product p1=Product.builder().productId(100).productName("Heater").productDoe(new Date()).productCost(500).build();
        Product p2=Product.builder().productId(200).productName("Heater2").productDoe(new Date()).productCost(5000).build();
        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(p1,p2));
        mockMvc.perform(get("/product-api/product"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getProductById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProductById() {
    }
}
