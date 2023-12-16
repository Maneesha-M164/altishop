package com.altimetrik.altishop.service;

import com.altimetrik.altishop.exception.ProductIdNotExistException;
import com.altimetrik.altishop.model.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(int productId) throws ProductIdNotExistException;

    public Product updateProduct(Product product) throws ProductIdNotExistException;

    public String deleteProductById(int productId) throws ProductIdNotExistException;
}
