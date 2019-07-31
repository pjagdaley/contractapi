package com.sundeus.contract.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sundeus.contract.exception.ResourceNotFoundException;
import com.sundeus.contract.model.Contract;
import com.sundeus.contract.model.DashboardContract;
import com.sundeus.contract.repository.ContractRepository;
import com.sundeus.contract.repository.ContractStatusRepository;
import com.sundeus.contract.repository.ContractTypeRepository;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("/api")
public class ContractController {

	@Autowired
    ContractRepository contractRepository;
	
	@Autowired
    ContractTypeRepository contractTypeRepository;
	
	@Autowired
    ContractStatusRepository contractStatusRepository;
	
	/*
	 * @RequestMapping("/") public String home() { return
	 * "Hello to all from Sundeus Technology June 23 2019..."; }
	 */
	
	// Get All Contracts
	@GetMapping("/contracts")
	public List<Contract> getAllContracts() {
	    return contractRepository.findAll();
	}
	
	// Get All Dashboard Contracts
	@GetMapping("/dashboard/contracts")
	public List<DashboardContract> getAllDashboardContracts() {
	    
		List<Contract> lContract = contractRepository.findAll();
		List<DashboardContract> lDashboardContract = new ArrayList<DashboardContract>();
		ListIterator<Contract> liContract = lContract.listIterator();
		while(liContract.hasNext()) {
			Contract contract = liContract.next();
			DashboardContract dashboardContract = new DashboardContract();
			dashboardContract.setId(contract.getId());
			dashboardContract.setContractName(contract.getName());
			dashboardContract.setCreatedBy(contract.getCreatedBy());
			dashboardContract.setCreatedDate(contract.getCreateDate());
			dashboardContract.setContractType((contractTypeRepository.findById(contract.getContractTypeId()).get().getName()));
			dashboardContract.setStatus(contractStatusRepository.findById(contract.getStatusId()).get().getName());
			lDashboardContract.add(dashboardContract);
		}		
		return lDashboardContract;
	}
	
	// Create a new Contract
	@PostMapping("/contracts")
	public Contract createContract(@Valid @RequestBody Contract contract) {
	    return contractRepository.save(contract);
	}
	
	// Get a Single Contract
	@GetMapping("/contracts/{id}")
	public Contract getContractById(@PathVariable(value = "id") Integer contractId) {
	    return contractRepository.findById(contractId)
	            .orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));
	}
	
	// Update a Contract
	@CrossOrigin
	@PutMapping("/contracts/{id}")
	public Contract updateContract(@PathVariable(value = "id") Integer contractId,
	                                        @Valid @RequestBody Contract contractDetails) {

	    Contract contract = contractRepository.findById(contractId)
	            .orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));

	    contract.setContractTypeId(contractDetails.getContractTypeId());
	    contract.setTransactionTypeId(contractDetails.getTransactionTypeId());
	    contract.setName(contractDetails.getName());
	    contract.setReason(contractDetails.getReason());
	    contract.setVersion(contractDetails.getVersion());
	    contract.setTemplateId(contractDetails.getTemplateId());
	    contract.setStatusId(contractDetails.getStatusId());
	    contract.setIsMandatoryFilled(contractDetails.getIsMandatoryFilled());
	    contract.setAiEnabled(contractDetails.getAiEnabled());
	    contract.setIsDeleted(contractDetails.getIsDeleted());
	    contract.setUpdateCount(contractDetails.getUpdateCount());
	    contract.setCreatedBy(contractDetails.getCreatedBy());
	    contract.setUpdatedBy(contractDetails.getUpdatedBy());
	    
	    Contract updatedContract = contractRepository.save(contract);
	    return updatedContract;
	}
	
	// Delete a Contract
	@CrossOrigin
	@DeleteMapping("/contracts/{id}")
	public ResponseEntity<?> deleteContract(@PathVariable(value = "id") Integer contractId) {
		Contract contract = contractRepository.findById(contractId)
	            .orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));

	    contractRepository.delete(contract);

	    return ResponseEntity.ok().build();
	}
}