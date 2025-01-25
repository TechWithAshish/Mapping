package com.example.mapping.Service;

import com.example.mapping.DTO.LockerDto;
import com.example.mapping.Entity.Customer.Customer;
import com.example.mapping.Entity.Locker.Locker;
import com.example.mapping.Repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;


@Service
public class LockerServiceImpl implements LockerService{

    @Autowired
    private LockerRepository lockerRepository;
    @Autowired
    private CustomerService customerService;

    @Override
    public Locker createLocker() {
        return lockerRepository.save(new Locker());
    }

    private Locker getLocker(int lockerId){
        return lockerRepository.findById(lockerId).orElseThrow(() -> new RuntimeException("No locker is found"));
    }

    @Override
    public Locker assignLockerToCustomer(LockerDto lockerDto) {
        Locker locker = lockerRepository.findById(lockerDto.getLockerId()).orElseThrow(() ->
                new RuntimeException("No Locker found"));
        Customer customer = customerService.getCustomerById(lockerDto.getCustomerId(), true, false);

        customer.getLockerList().add(locker);
        locker.getCustomerList().add(customer);
        return lockerRepository.save(locker);
    }

    @Override
    public Locker withHoldLockerToCustomer(LockerDto lockerDto) {
        Locker locker = lockerRepository.findById(lockerDto.getLockerId()).orElseThrow(() ->
                new RuntimeException("No Locker found"));
        Customer customer = customerService.getCustomerById(lockerDto.getCustomerId(), true, false);
        Set<Customer> customerList = locker.getCustomerList();
        Set<Locker> lockerList = customer.getLockerList();

        // now need to remove customer from locker and remove locker from customer...
        lockerList.remove(locker);
        customerList.remove(customer);
        return lockerRepository.save(locker);
    }

    @Override
    public void deleteLocker(int lockerId) {
        // we need to remove it from every customer....
        Locker locker = getLocker(lockerId);
        for(Customer customer : locker.getCustomerList()){
            customer.getLockerList().remove(locker);
        }
        locker.getCustomerList().clear();
        lockerRepository.delete(locker);
    }
}
