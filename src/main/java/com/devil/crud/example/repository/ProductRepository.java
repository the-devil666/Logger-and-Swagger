package com.devil.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devil.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}

