package com.example.mapping.Repository;

import com.example.mapping.Entity.Card.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {
}
