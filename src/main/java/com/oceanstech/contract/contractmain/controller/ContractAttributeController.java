package com.oceanstech.contract.contractmain.controller;

import com.oceanstech.contract.contractmain.exception.ResourceNotFoundException;
import com.oceanstech.contract.contractmain.model.ContractAttribute;
import com.oceanstech.contract.contractmain.repository.ContractAttributeRepository;
import com.oceanstech.contract.contractmain.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractAttributeController {

	@Autowired
    ContractRepository contractRepository;
	
	@Autowired
    ContractAttributeRepository contractAttributeRepository;
	
	// Get a Single Contract Attribute
	@GetMapping("/contracts/{contractId}/contractattributes/{contractAttributeId}")
	public ContractAttribute getContractAttributeById(@PathVariable(value = "contractAttributeId") Integer contractAttributeId) {
	    return contractAttributeRepository.findById(contractAttributeId)
	            .orElseThrow(() -> new ResourceNotFoundException("ContractAttribute", "id", contractAttributeId));
	}
	
	// Get All Contract Attributes
	@GetMapping("/contracts/{contractId}/contractattributes")
	public List<ContractAttribute> getAllContractAttributess(@PathVariable (value = "contractId") Integer contractId) {
	    return contractAttributeRepository.findByContractId(contractId);
	}
			
	@PostMapping("/contracts/{contractId}/contractattributes")
    public List<ContractAttribute> createContractAttribute(@PathVariable (value = "contractId") Integer contractId,
                                 @Valid @RequestBody List<ContractAttribute> contractAttributes) {
        return contractRepository.findById(contractId).map(contract -> {
        	contractAttributes.forEach(contractAttribute -> contractAttribute.setContract(contract));
        	return contractAttributeRepository.saveAll(contractAttributes);
        }).orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));
    }
	
	@PutMapping("/contracts/{contractId}/contractattributes/{contractAttributeId}")
    public ContractAttribute updateContractAttribute(@PathVariable (value = "contractId") Integer contractId,
                                 @PathVariable (value = "contractAttributeId") Integer contractAttributeId,
                                 @Valid @RequestBody ContractAttribute contractAttributeRequest) {
        if(!contractRepository.existsById(contractId)) {
            throw new ResourceNotFoundException("Contract", "id", contractId);
        }

        return contractAttributeRepository.findById(contractAttributeId).map(contractAttribute -> {
        	contractAttribute.setAttributeValue(contractAttributeRequest.getAttributeValue());
    	    //contract.setDescription(contractDetails.getDescription());
    	    //contract.setVersion(contractDetails.getVersion());
    	    //contractAttribute.setTemplateId(contractDetails.getTemplateId());
    	    contractAttribute.setUpdateCount(contractAttributeRequest.getUpdateCount());
    	    contractAttribute.setCreatedBy(contractAttributeRequest.getCreatedBy());
    	    contractAttribute.setUpdatedBy(contractAttributeRequest.getUpdatedBy());
            return contractAttributeRepository.save(contractAttribute);
        }).orElseThrow(() -> new ResourceNotFoundException("ContractAttribute", "id", contractAttributeId));
    }
	
	
	
	@DeleteMapping("/contracts/{contractId}/contractattributes/{contractAttributeId}")
    public ResponseEntity<?> deleteContractAttribute(@PathVariable (value = "contractId") Integer contractId,
                              @PathVariable (value = "contractAttributeId") Integer contractAttributeId) {
        return contractAttributeRepository.findByIdAndContractId(contractAttributeId, contractId).map(contractAttribute -> {
        	contractAttributeRepository.delete(contractAttribute);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ContractAttribute", "id", contractAttributeId));
    }	
}
