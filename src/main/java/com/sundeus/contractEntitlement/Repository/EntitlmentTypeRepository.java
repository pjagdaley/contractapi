package com.sundeus.contractEntitlement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundeus.contractEntitlement.Model.EntitlementType;


@Repository
public interface EntitlmentTypeRepository extends JpaRepository<EntitlementType, Integer> {
	
	public Optional<EntitlementType> getEntitlementTypeById(Integer id);
}
