package com.sundeus.contractEntitlement.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundeus.contractEntitlement.Model.ContractEntitlements;


@Repository
public interface ContractEntitlementRepository extends JpaRepository<ContractEntitlements, Integer>{

	List<ContractEntitlements> findByContractId(Integer contractId);
	 Optional<ContractEntitlements> findByIdAndContractId(Integer id, Integer contractId);
}
