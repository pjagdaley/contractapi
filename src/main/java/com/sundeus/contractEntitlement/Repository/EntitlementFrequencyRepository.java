package com.sundeus.contractEntitlement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundeus.contractEntitlement.Model.EntitlementFrequency;


@Repository
public interface EntitlementFrequencyRepository extends JpaRepository<EntitlementFrequency, Integer>{

	public Optional<EntitlementFrequency> getEntitlementFrequencyById(Integer id);
}
