package com.dxctraining.productmgt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;
import com.dxctraining.productmgt.dao.IProductDao;
import com.dxctraining.productmgt.entities.Product;
import com.dxctraining.productmgt.exceptions.InvalidArgumentException;
import com.dxctraining.productmgt.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
	
	 @Autowired
	 private MongoTemplate mongo;

    @Autowired
    private IProductDao dao;


    @Override
    public Product save(Product product) {
       product= dao.save(product);
       return product;
    }
    
    
    @Override
	public List<Product> findByName(String name) {
		List<Product>list = dao.findByName(name);
		return list;
	}
    
    
    @Override
   	public List<Product> findByName1(String name) {
   		Criteria criteria = Criteria.where("name").is(name);
   		Query query = Query.query(criteria);
   		List<Product> list = mongo.find(query, Product.class);
   		return list;
   	}

	@Override
    public Product findById(String id) {
      Optional<Product>optional= dao.findById(id);
      boolean exist=optional.isPresent();
      if(!exist){
          throw new ProductNotFoundException("product not found for id="+id);
      }
      Product product=optional.get();
       return product;
    }

	@Override
	public List<Product> findAll() {
		List<Product>list = dao.findAll(Product.class);
		return list;
	}

    
}
