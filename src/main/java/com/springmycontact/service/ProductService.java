package com.springmycontact.service;

import java.util.List;

import com.springmycontact.domain.Product;

public interface ProductService {

	Iterable<Product> findAll();

	List<Product> search(String q);

	Product findOne(int id);

	void save(Product product);

	void delete(int id);

}

