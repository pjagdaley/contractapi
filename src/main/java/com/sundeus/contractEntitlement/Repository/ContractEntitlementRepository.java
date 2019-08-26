package com.sundeus.contractEntitlement.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sundeus.contractEntitlement.Model.ContractEntitlements;

@Repository
public interface ContractEntitlementRepository extends JpaRepository<ContractEntitlements, Integer>{

	
}
