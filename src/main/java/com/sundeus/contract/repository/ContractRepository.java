package com.sundeus.contract.repository;
import com.sundeus.contract.model.Contract;
import com.sundeus.user.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
	
	List<Contract> findByCreatedBy(String createdBy);

}