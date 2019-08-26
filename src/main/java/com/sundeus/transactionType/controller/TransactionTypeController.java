package com.sundeus.transactionType.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sundeus.role.exception.ResourceNotFoundException;
import com.sundeus.transactionType.model.TransactionType;
import com.sundeus.transactionType.repository.TransactionTypeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionTypeController {

	@Autowired
	TransactionTypeRepository transactionTypeRepository;
	
	//Get All TransactionTypes
	@GetMapping("/transactionTypes")
	public List<TransactionType> getAllTransactionTypes() {
	    return transactionTypeRepository.findAll();
	}
	
	//Create a new TransactionType
	@CrossOrigin
	@PostMapping("/transactionTypes")
	public TransactionType createTransactionType(@Valid @RequestBody TransactionType transactionType) {
	    return transactionTypeRepository.save(transactionType);
	}
	
	//Get a Single TransactionType
	@GetMapping("/transactionTypes/{id}")
	public TransactionType getTransactionTypeById(@PathVariable(value = "id") Integer transactionTypeId) {
	    return transactionTypeRepository.findById(transactionTypeId)
	            .orElseThrow(() -> new ResourceNotFoundException("TransactionType", "id", transactionTypeId));
	}
	
	//Update TransactionType
	@CrossOrigin
	@PutMapping("/transactionTypes/{id}")
	public TransactionType updateTransactionType(@PathVariable(value = "id") Integer transactionTypeId,
	                                        @Valid @RequestBody TransactionType transactionTypeDetails) {

		TransactionType transactionType = transactionTypeRepository.findById(transactionTypeId)
	            .orElseThrow(() -> new ResourceNotFoundException("TransactionType", "id", transactionTypeId));

		transactionType.setName(transactionTypeDetails.getName());
		transactionType.setDescription(transactionTypeDetails.getDescription());
		transactionType.setIsDeleted(transactionTypeDetails.getIsDeleted());	
		transactionType.setUpdateCount(transactionTypeDetails.getUpdateCount());		
		transactionType.setUpdatedBy(transactionTypeDetails.getUpdatedBy());
	    
		TransactionType updatedTransactionType = transactionTypeRepository.save(transactionType);
	    return updatedTransactionType;
	}
	
	// Delete a TransactionType
	@CrossOrigin
	@DeleteMapping("/transactionTypes/{id}")
	public ResponseEntity<?> deleteTransactionType(@PathVariable(value = "id") Integer transactionTypeId) {
		TransactionType transactionType = transactionTypeRepository.findById(transactionTypeId)
	            .orElseThrow(() -> new ResourceNotFoundException("TransactionType", "id", transactionTypeId));

		transactionTypeRepository.delete(transactionType);

	    return ResponseEntity.ok().build();
	}
}