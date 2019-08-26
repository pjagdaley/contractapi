package com.sundeus.contractEntitlement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundeus.contractEntitlement.Model.EntitlementTimeLines;

@Repository
public interface EntitlementTimeLineRepository extends JpaRepository<EntitlementTimeLines, Integer>{
   
	public Optional<EntitlementTimeLines> getEntitlementTimeLineById(Integer id);
}
