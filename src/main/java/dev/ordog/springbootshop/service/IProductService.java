package dev.ordog.springbootshop.service;

import dev.ordog.springbootshop.model.Product;

import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findAllProducts();
}
