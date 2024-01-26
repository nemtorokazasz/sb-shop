package dev.ordog.springbootshop.repository;

import dev.ordog.springbootshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {



}
