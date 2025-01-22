package com.example.mapping.Repository;

import com.example.mapping.Entity.Loan.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccount, Integer> {
}
