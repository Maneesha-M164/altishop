package com.altimetrik.altishop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue
    private int productId;
    @NotEmpty(message = "Please enter the Product Name")
    private String productName;
    @Future(message = "Please enter the Future Date for doe")
    @NotNull(message = "Please enter the Product Doe")
    private Date productDoe;
    //@NotNull
    @Positive(message = "Please enter the Positive Value")
    private float productCost;
    private boolean isAvailable;

}
