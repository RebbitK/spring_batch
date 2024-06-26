package com.sparta.springbatch.domain.product.repository;

import com.sparta.springbatch.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
