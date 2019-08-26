package com.sundeus.contractEntitlement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundeus.contractEntitlement.Model.EntitlementApproval;

@Repository
public interface EntitlementApprovalRepository extends JpaRepository<EntitlementApproval, Integer>{

	public Optional<EntitlementApproval> getEntitlementApprovalById(Integer id);
}
