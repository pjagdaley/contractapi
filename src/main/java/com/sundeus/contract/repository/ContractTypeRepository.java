package com.sundeus.contract.repository;

import com.sundeus.contract.model.ContractType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {

}



