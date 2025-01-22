package com.example.mapping.Repository;

import com.example.mapping.Entity.Account.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer> {
}
