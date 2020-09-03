package com.dxctraining.productmgt.service;

import java.util.List;


import com.dxctraining.productmgt.entities.Product;

public interface IProductService {

    Product save(Product product);

    Product findById(String id);

    List<Product> findByName(String name);
    
    List<Product> allProducts();
    
    List<Product> findByName1(String name);

}
