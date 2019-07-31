package com.sundeus.contract.repository;

import com.sundeus.contract.model.Attribute;

import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
	
	Optional<Attribute> findByIdAndIsDisplaySummary(Integer id, Boolean bSummaryIndicator);
	
}