package com.sundeus.contract.repository;
import com.sundeus.contract.model.ContractStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractStatusRepository extends JpaRepository<ContractStatus, Integer> {

}



