package com.altimetrik.altishop.repository;

import com.altimetrik.altishop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
