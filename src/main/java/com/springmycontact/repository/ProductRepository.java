package com.springmycontact.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springmycontact.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByNameContaining(String q);

}
