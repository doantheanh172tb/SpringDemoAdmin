package com.springmycontact.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmycontact.domain.Product;
import com.springmycontact.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> search(String q) {
		return productRepository.findByNameContaining(q);
	}

	@Override
	public Product findOne(int id) {
		return productRepository.findOne(id);
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void delete(int id) {
		productRepository.delete(id);
	}

}
