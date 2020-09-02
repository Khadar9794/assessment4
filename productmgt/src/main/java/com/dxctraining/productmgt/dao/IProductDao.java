package com.dxctraining.productmgt.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.productmgt.entities.Product;

public interface IProductDao extends MongoRepository<Product, String> {
	
	List<Product> findByName(String name);
}
