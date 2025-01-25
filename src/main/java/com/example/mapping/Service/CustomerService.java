package com.example.mapping.Service;

import com.example.mapping.DTO.CustomerDto;
import com.example.mapping.Entity.Customer.Customer;

public interface CustomerService {
    public Customer createCustomer(CustomerDto customerDto);
    public Customer getCustomerById(int customerId, boolean isLocker, boolean isAccount);
    public void deleteCustomer(int customerId);
    public Customer updateCustomer(Customer customer);
}
