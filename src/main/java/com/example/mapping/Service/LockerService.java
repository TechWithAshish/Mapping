package com.example.mapping.Service;

import com.example.mapping.DTO.LockerDto;
import com.example.mapping.Entity.Locker.Locker;

public interface LockerService {
    public Locker createLocker();
    public Locker assignLockerToCustomer(LockerDto lockerDto);
    public Locker withHoldLockerToCustomer(LockerDto lockerDto);
    public void deleteLocker(int lockerId);
}
