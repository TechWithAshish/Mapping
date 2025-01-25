package com.example.mapping.Serializer;

import com.example.mapping.Entity.Customer.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CustomerConditionalSerializer extends JsonSerializer<Customer> {
    @Override
    public void serialize(Customer customer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("customerId", customer.getCustomerId());
        jsonGenerator.writeStringField("name", customer.getName());
        jsonGenerator.writeStringField("mobileNumber", customer.getMobileNumber());
        jsonGenerator.writeStringField("email", customer.getEmail());
        jsonGenerator.writeObjectField("addresses", customer.getAddresses());
        jsonGenerator.writeObjectField("creditCards", customer.getCreditCards());
        jsonGenerator.writeObjectField("loanAccounts", customer.getLoanAccounts());

        if(customer.isIncludeLocker()){
            // log.info("inside customer Json serializer {}", customer.isIncludeDetailedData());
            jsonGenerator.writeObjectField("lockerList", customer.getLockerList());
        }
        if(customer.isIncludeAccount()){
            jsonGenerator.writeObjectField("accounts", customer.getAccounts());
        }
        log.info("inside customer Json serializer {}", customer.getCreditCards().size());
        jsonGenerator.writeEndObject();
    }
}
