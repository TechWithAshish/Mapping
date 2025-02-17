package com.example.mapping.Service;

import com.example.mapping.DTO.CustomerDto;
import com.example.mapping.Entity.Customer.Address;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Locker.Locker;
import com.example.mapping.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
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
    @Transactional
    public Customer getCustomerById(int customerId, boolean isLocker, boolean isAccount) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("No customer found"));
//        if(isLocker){
//            log.info("Inside get customer with isLocker {}", true);
//            Set<Locker> lockerList = customer.getLockerList();
//            log.info("locker list size {}", lockerList.size());
//            customer.setLockerList(lockerList);
//        }
        customer.setLockerFlag(isLocker);
        customer.setAccountFlag(isAccount);
        log.info("{} ", customer.getName());
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = getCustomerById(customerId, true, true);
        Set<Locker> lockerList = customer.getLockerList();
        for(Locker locker : lockerList){
            locker.getCustomerList().remove(customer);
        }
        lockerList.clear();
        customerRepository.delete(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
