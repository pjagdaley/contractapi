package com.sundeus.contract.repository;

import com.sundeus.contract.model.ContractAttribute;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractAttributeRepository extends JpaRepository<ContractAttribute, Integer> {

	List<ContractAttribute> findByContractId(Integer contractId);
    Optional<ContractAttribute> findByIdAndContractId(Integer id, Integer contractId);
}



