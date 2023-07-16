package com.example.catalogueservice.repository;

import com.example.catalogueservice.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
