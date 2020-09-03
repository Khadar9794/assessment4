package com.dxctraining.customermgt.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.customermgt.customer.dto.CreateCustomerRequest;
import com.dxctraining.customermgt.customer.dto.CustomerDto;
import com.dxctraining.customermgt.customer.entities.Customer;
import com.dxctraining.customermgt.customer.service.ICustomerService;
import com.dxctraining.customermgt.customer.util.CustomerUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerUtil util;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping(value = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer Create(@RequestBody CreateCustomerRequest requestData) {
		Customer customer = new Customer(requestData.getName());
		customer = customerService.save(customer);
		CustomerDto response = util.customerDto(customer);
		return customer;
	}
    
    @GetMapping("/get/{id}")
	public Customer findCustomer(@PathVariable("id")int id) {
		Customer customer = customerService.findCustomerById(id);
		CustomerDto response = util.customerDto(customer);
		return customer;
	}
    
    
    @GetMapping("/get/customer/{name}")
    public List<CustomerDto> findCustomer(@PathVariable("name")String name){
    	List<Customer> list = customerService.findByName(name);
    	List<CustomerDto> response = new ArrayList<>();
    	for (Customer customer:list) {
    		CustomerDto dto = util.customerDto(customer);
    		response.add(dto);
    	}
		return response;
    	
    }

    @GetMapping
    public List<CustomerDto> fetchAll() {
        List<Customer> list = customerService.allCustomers();
        List<CustomerDto>response=new ArrayList<>();
        for (Customer customer:list){
            CustomerDto dto=util.customerDto(customer);
            response.add(dto);
        }
        return response;
    }
    

}




