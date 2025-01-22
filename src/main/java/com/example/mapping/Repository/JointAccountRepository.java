package com.example.mapping.Repository;

import com.example.mapping.Entity.Account.JointAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointAccountRepository extends JpaRepository<JointAccount, Integer> {
}
