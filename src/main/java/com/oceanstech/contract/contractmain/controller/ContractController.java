package com.oceanstech.contract.contractmain.controller;

import com.oceanstech.contract.contractmain.exception.ResourceNotFoundException;
import com.oceanstech.contract.contractmain.model.Contract;
import com.oceanstech.contract.contractmain.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractController {

	@Autowired
    ContractRepository contractRepository;
	
	@RequestMapping("/")
    public String home() {
        return "Hello Spring Boot World Pankaj Jagdaley";
    }
	
	// Get All Contracts
	@GetMapping("/contracts")
	public List<Contract> getAllContracts() {
	    return contractRepository.findAll();
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
	    contract.setStatus(contractDetails.getStatus());
	    contract.setAiEnabled(contractDetails.getAiEnabled());
	    contract.setUpdateCount(contractDetails.getUpdateCount());
	    contract.setCreatedBy(contractDetails.getCreatedBy());
	    contract.setUpdatedBy(contractDetails.getUpdatedBy());
	    
	    Contract updatedContract = contractRepository.save(contract);
	    return updatedContract;
	}
	
	// Delete a Contract
	@DeleteMapping("/contracts/{id}")
	public ResponseEntity<?> deleteContract(@PathVariable(value = "id") Integer contractId) {
		Contract contract = contractRepository.findById(contractId)
	            .orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));

	    contractRepository.delete(contract);

	    return ResponseEntity.ok().build();
	}
}