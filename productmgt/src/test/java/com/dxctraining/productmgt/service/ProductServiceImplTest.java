package com.dxctraining.productmgt.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.productmgt.entities.Product;
import com.dxctraining.productmgt.exceptions.InvalidArgumentException;
import com.dxctraining.productmgt.exceptions.ProductNotFoundException;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@Import({ProductServiceImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductServiceImplTest {
	
	@Autowired
	private IProductService service;
	
	@Autowired
	EntityManager entityManager;

	@Test
	public void testAdd_1() {
		Executable executable=()->service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable);
	}
	
	@Test
	public void testAdd_2() {
		String name = "watch";
		Product product = new Product(name);
		product = service.save(product);
		
		
		TypedQuery<Product> query=entityManager.createQuery("from Product",Product.class);
		List<Product>list=query.getResultList();
		Assertions.assertEquals(1,list.size());
		Product fetched=list.get(0);
		Assertions.assertEquals(product.getId(),fetched.getId());
		Assertions.assertEquals(product.getName(),fetched.getName());
	}


}
