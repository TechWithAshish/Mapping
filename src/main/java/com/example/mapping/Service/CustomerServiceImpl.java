package com.example.mapping.Service;

import com.example.mapping.DTO.CustomerDto;
import com.example.mapping.Entity.Customer.Address;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        Address address1 = new Address();
        Address address2 = new Address();
        address1.setAddress(customerDto.getCurrentAddress());
        address2.setAddress(customerDto.getPermanentAddress());
        address1.setCustomer(customer);
        address2.setCustomer(customer);
        List<Address> addresses = customer.getAddresses();
        addresses.add(address1);
        addresses.add(address2);

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("No customer found"));
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
