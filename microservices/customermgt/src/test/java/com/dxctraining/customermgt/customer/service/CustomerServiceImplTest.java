package com.dxctraining.customermgt.customer.service;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.exceptions.InvalidArgumentException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({CustomerServiceImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceImplTest {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	EntityManager entityManager;

	@Test
	public void testAdd_1() {
		Executable execute=()->service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, execute);
	}
	
	@Test
	public void testAdd_2() {
		String name = "khadar";
		Customer customer = new Customer(name);
		customer = service.save(customer);
		

		TypedQuery<Customer> query=entityManager.createQuery("from Customer",Customer.class);
		List<Customer>list=query.getResultList();
		Assertions.assertEquals(1,list.size());
		Customer fetched=list.get(0);
		Assertions.assertEquals(customer.getId(),fetched.getId());
		Assertions.assertEquals(customer.getName(),fetched.getName());
	}
	
}
