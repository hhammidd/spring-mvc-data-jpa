package com.spring.banking.app1.service;

import com.spring.banking.app1.model.Product;
import com.spring.banking.app1.repository.ProductRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * Service layer.
 * Specify transactional behavior and mainly
 * delegate calls to Repository.
 */
@Component
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void add(Product product) {
		productRepository.save(product);
	}
	
	@Transactional(readOnly=true)
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productRepository.save(product);
		}
	}

	@Transactional(readOnly=true)
	public List<Product> findByNameIs(String name) {
		return productRepository.findByNameIs(name);
	}
	
	@Transactional(readOnly=true)
	public List<Product> findByNameContainingIgnoreCase(String searchString) {
		return productRepository.findByNameContainingIgnoreCase(searchString);
	}
}
