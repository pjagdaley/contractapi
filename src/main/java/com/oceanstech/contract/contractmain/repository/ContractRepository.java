package com.oceanstech.contract.contractmain.repository;

import com.oceanstech.contract.contractmain.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

}



