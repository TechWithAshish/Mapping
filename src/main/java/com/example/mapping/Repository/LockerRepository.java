package com.example.mapping.Repository;

import com.example.mapping.Entity.Locker.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Integer> {
}
