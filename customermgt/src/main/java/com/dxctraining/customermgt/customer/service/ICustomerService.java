package com.dxctraining.customermgt.customer.service;


import java.util.List;


import com.dxctraining.customermgt.customer.entities.*;

public interface ICustomerService {

    Customer findCustomerById(int id);

    Customer save(Customer customer);
    
    List<Customer> findByName(String name);

    List<Customer> allCustomers();

}
