package com.altimetrik.altishop.controller;

import com.altimetrik.altishop.exception.ProductIdNotExistException;
import com.altimetrik.altishop.model.Product;
import com.altimetrik.altishop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-api")
public class ProductController {
    @Autowired
    private ProductService productService;

    //@RequestMapping(value = "/product-api/product", method = RequestMethod.POST)
    @PostMapping(value = "/product")
    //@ResponseBody
    public Product addProduct(@RequestBody @Valid Product product)
    {

        return productService.addProduct(product);
    }

    //@RequestMapping(value = "product-api/product", method = RequestMethod.GET)
    @GetMapping(value = "/product")
    //@ResponseBody
    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }

    //@RequestMapping(value = "product-api/product/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/product/{id}")
    //@ResponseBody
    public Product getProductById(@PathVariable("id")  int productId) throws ProductIdNotExistException {
        return productService.getProductById(productId);
    }

   // @RequestMapping(value = "product-api/product", method = RequestMethod.PUT)
    @PutMapping(value = "/product")
    //@ResponseBody
    public Product updateProduct(@RequestBody Product product) throws ProductIdNotExistException {

        return productService.updateProduct(product);
    }

    //@RequestMapping(value = "product-api/product/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/product/{id}")
    //@ResponseBody
    public String deleteProductById(@PathVariable("id") int productId) throws ProductIdNotExistException {
        return productService.deleteProductById(productId);
    }
}
