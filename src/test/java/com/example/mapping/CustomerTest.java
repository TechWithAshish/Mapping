package com.example.mapping;


import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
public class CustomerTest {
    @Autowired
    public CustomerRepository customerRepository;

    @Test
    public void checkCustomer(){
        Customer customer = new Customer();
        customer.setName("Ashish Kumar");
        customer.setMobileNumber("8126365663");
        customer.setEmail("Ashish@gmail.com");

        Customer savedCustomer = customerRepository.save(customer);

        Assertions.assertEquals(savedCustomer.getCreditCards().size(), 0);
        Assertions.assertEquals(savedCustomer.getAccounts().size(), 0);
        Assertions.assertEquals(savedCustomer.getLoanAccounts().size(), 0);
        Assertions.assertEquals(savedCustomer.getCustomerId(), 1);

    }
}
