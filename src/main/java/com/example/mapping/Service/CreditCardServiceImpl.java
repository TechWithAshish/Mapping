package com.example.mapping.Service;

import com.example.mapping.DTO.CardDto;
import com.example.mapping.Entity.Card.CreditCard;
import com.example.mapping.Entity.Card.RandomCardType;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private CustomerService customerService;

    @Override
    public CreditCard createCreditCard(CardDto cardDto) {
        Customer customerById = customerService.getCustomerById(cardDto.getCustomerId());
        CreditCard creditCard = new CreditCard();
        creditCard.setName(cardDto.getName());
        creditCard.setCardSubType(RandomCardType.randomSelectionOfCard());
        creditCard.setCustomer(customerById);
        creditCard.setExpiryDate(LocalDate.now().plusYears(4)
                .plusMonths(3)
                .plusDays(10));

        // adding credit card to customer list....
        customerById.getCreditCards().add(creditCard);
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard getCreditCard(int id) {
        return creditCardRepository.findById(id).orElseThrow(() -> new RuntimeException("No Credit card found"));
    }

    @Override
    public void deleteCreditCard(int id) {
        creditCardRepository.deleteById(id);
    }

}
