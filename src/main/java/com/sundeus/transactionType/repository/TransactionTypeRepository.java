package com.sundeus.transactionType.repository;

import com.sundeus.transactionType.model.TransactionType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}



