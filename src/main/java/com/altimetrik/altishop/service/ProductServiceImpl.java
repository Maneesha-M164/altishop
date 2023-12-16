package com.altimetrik.altishop.service;

import com.altimetrik.altishop.exception.ProductIdNotExistException;
import com.altimetrik.altishop.model.Product;
import com.altimetrik.altishop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;//Make a dummy for test for that we have to use mokito

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) throws ProductIdNotExistException {
        Optional<Product> pro = productRepository.findById(productId);
        if (pro.isEmpty()) {
            throw new ProductIdNotExistException("Product is not exists in the db!!! check the product ID");
        }
        return pro.get();
    }

    @Override
    public Product updateProduct(Product product) throws ProductIdNotExistException {
        if (getProductById(product.getProductId()) != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public String deleteProductById(int productId) throws ProductIdNotExistException {
        String message = "product does not exist";
        Product p = getProductById(productId);
        if (p != null) {
            productRepository.deleteById(productId);
            message = "product deleted succesfully";
            return message;
        }
        return message;
    }
}
