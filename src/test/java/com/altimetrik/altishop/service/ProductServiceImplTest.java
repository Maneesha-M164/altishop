package com.altimetrik.altishop.service;

import com.altimetrik.altishop.exception.ProductIdNotExistException;
import com.altimetrik.altishop.model.Product;
import com.altimetrik.altishop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Test
    void addProduct() {
        Product p1=Product.builder().productId(100).productName("Heater").productDoe(new Date()).productCost(500).build();
        Mockito.when(productRepository.save(p1)).thenReturn(p1);
        assertEquals(p1,productServiceImpl.addProduct(p1));
    }

    @Test
    void getAllProducts() {
        Product p1=Product.builder().productId(100).productName("Heater").productDoe(new Date()).productCost(500).build();
        Product p2=Product.builder().productId(200).productName("Heater2").productDoe(new Date()).productCost(5000).build();
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(p1,p2));
        assertEquals(2,productServiceImpl.getAllProducts().size());

    }

    @Test
    void getProductById() throws ProductIdNotExistException {
        Product p1=Product.builder().productId(100).productName("Heater").productDoe(new Date()).productCost(500).build();
        Mockito.when(productRepository.findById(100)).thenReturn(Optional.of(p1));
        assertEquals(p1,productServiceImpl.getProductById(100));
    }
    @Test
    void getProductByIdWithExceprtion() throws ProductIdNotExistException {
        Product p1 = Product.builder().productId(100).productName("Heater").productDoe(new Date()).productCost(500).build();
        Mockito.when(productRepository.findById(900)).thenReturn(Optional.empty());
        assertThrows(ProductIdNotExistException.class,()->{productServiceImpl.getProductById(900);});
    }

    @Test
    void updateProduct() throws ProductIdNotExistException {
        Product p1 = Product.builder().productId(100).productName("Heater5").productDoe(new Date()).productCost(500).build();
        Mockito.when(productRepository.findById(100)).thenReturn(Optional.of(p1));
        Mockito.when(productRepository.save(p1)).thenReturn(p1);
        assertEquals(p1,productServiceImpl.updateProduct(p1));
    }

    @Test
    void deleteProductById() {
    }
}