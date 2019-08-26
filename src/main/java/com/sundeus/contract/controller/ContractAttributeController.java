package com.sundeus.contract.controller;

import com.sundeus.contract.exception.ResourceNotFoundException;
import com.sundeus.contract.model.Attribute;
import com.sundeus.contract.model.UIAttribute;
import com.sundeus.contract.model.ContractAttribute;
import com.sundeus.contract.repository.AttributeRepository;
import com.sundeus.contract.repository.ContractAttributeRepository;
import com.sundeus.contract.repository.ContractRepository;
import com.sundeus.contract.repository.SectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContractAttributeController {

	@Autowired
    ContractRepository contractRepository;
	
	@Autowired
    ContractAttributeRepository contractAttributeRepository;
	
	@Autowired
    AttributeRepository attributeRepository;
	
	@Autowired
    SectionRepository sectionRepository;
	
	//Get a Single Contract Attribute
	@GetMapping("/contracts/{contractId}/contractattributes/{contractAttributeId}")
	public ContractAttribute getContractAttributeById(@PathVariable(value = "contractAttributeId") Integer contractAttributeId) {
	    return contractAttributeRepository.findById(contractAttributeId)
	            .orElseThrow(() -> new ResourceNotFoundException("ContractAttribute", "id", contractAttributeId));
	}
	
	//Get All Contract Attributes
	@GetMapping("/contracts/{contractId}/contractattributes")
	public List<ContractAttribute> getAllContractAttributes(@PathVariable (value = "contractId") Integer contractId) {
	    return contractAttributeRepository.findByContractId(contractId);
	}
	
	//Get All Contract Summary Attributes
	@GetMapping("/contracts/{contractId}/contractsummaryattributes")
	public List<UIAttribute> getAllContractSummaryAttributes(@PathVariable (value = "contractId") Integer contractId) {
	    
		List<ContractAttribute> lContractAttribute = contractAttributeRepository.findByContractId(contractId);
				
		List<UIAttribute> lUIAttribute = new ArrayList<UIAttribute>();
		
		Optional<Attribute> oAttribute = null;
		Attribute attribute = null;
		
		for (ContractAttribute contractAttribute : lContractAttribute) {
			
			//Attribute attribute = attributeRepository.findById(contractAttribute.getAttributeId()).get();
			oAttribute = attributeRepository.findByIdAndIsDisplaySummary(contractAttribute.getAttributeId(), true);
			
			if (oAttribute.isPresent()) {
				
				attribute = oAttribute.get();
			
				UIAttribute uiAttribute = new UIAttribute();
				uiAttribute.setAttributeId(attribute.getId());
				uiAttribute.setAttributeLabel(attribute.getLabel());
				uiAttribute.setAttributeValue(contractAttribute.getAttributeValue());
				uiAttribute.setSectionId(attribute.getSectionId());
				uiAttribute.setSequenceNo(attribute.getSequenceNo());
				uiAttribute.setSectionName(sectionRepository.findById(attribute.getSectionId()).get().getName());
				
				lUIAttribute.add(uiAttribute);			
			}
		}
		
		return lUIAttribute;
	}
	
	//Get All Contract Details Attributes
	@GetMapping("/contracts/{contractId}/contractdetailattributes")
	public List<UIAttribute> getAllContractDetailAttributes(@PathVariable (value = "contractId") Integer contractId) {
	    
		List<ContractAttribute> lContractAttribute = contractAttributeRepository.findByContractId(contractId);
				
		List<UIAttribute> lUIAttribute = new ArrayList<UIAttribute>();
		
		Optional<Attribute> oAttribute = null;
		Attribute attribute = null;
		
		for (ContractAttribute contractAttribute : lContractAttribute) {
			
			//Attribute attribute = attributeRepository.findById(contractAttribute.getAttributeId()).get();
			oAttribute = attributeRepository.findByIdAndIsDisplaySummary(contractAttribute.getAttributeId(), false);
			
			if (oAttribute.isPresent()) {
				attribute = oAttribute.get();
			
				UIAttribute uiAttribute = new UIAttribute();
				uiAttribute.setAttributeId(attribute.getId());
				uiAttribute.setAttributeLabel(attribute.getLabel());
				uiAttribute.setAttributeValue(contractAttribute.getAttributeValue());
				uiAttribute.setSectionId(attribute.getSectionId());
				uiAttribute.setSequenceNo(attribute.getSequenceNo());
				uiAttribute.setSectionName(sectionRepository.findById(attribute.getSectionId()).get().getName());
				
				lUIAttribute.add(uiAttribute);			
			}
		}
		
		return lUIAttribute;
	}
			
	@CrossOrigin
	@PostMapping("/contracts/{contractId}/contractattributes")
    public List<ContractAttribute> createContractAttribute(@PathVariable (value = "contractId") Integer contractId,
                                 @Valid @RequestBody List<ContractAttribute> contractAttributes) {
        return contractRepository.findById(contractId).map(contract -> {
        	contractAttributes.forEach(contractAttribute -> contractAttribute.setContract(contract));
        	return contractAttributeRepository.saveAll(contractAttributes);
        }).orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));
    }
	
	@CrossOrigin
	@PutMapping("/contracts/{contractId}/contractattributes/{contractAttributeId}")
    public ContractAttribute updateContractAttribute(@PathVariable (value = "contractId") Integer contractId,
                                 @PathVariable (value = "contractAttributeId") Integer contractAttributeId,
                                 @Valid @RequestBody ContractAttribute contractAttributeRequest) {
        if(!contractRepository.existsById(contractId)) {
            throw new ResourceNotFoundException("Contract", "id", contractId);
        }

        return contractAttributeRepository.findById(contractAttributeId).map(contractAttribute -> {
        	contractAttribute.setAttributeValue(contractAttributeRequest.getAttributeValue());
        	contractAttribute.setAttributeId(contractAttributeRequest.getAttributeId());
        	//contractAttribute.setContract(contractAttributeRequest.getContract());
        	contractAttribute.setIsDeleted(contractAttributeRequest.getIsDeleted());
    	    contractAttribute.setUpdateCount(contractAttributeRequest.getUpdateCount());
    	    contractAttribute.setCreatedBy(contractAttributeRequest.getCreatedBy());
    	    contractAttribute.setUpdatedBy(contractAttributeRequest.getUpdatedBy());
            return contractAttributeRepository.save(contractAttribute);
        }).orElseThrow(() -> new ResourceNotFoundException("ContractAttribute", "id", contractAttributeId));
    }
	
	
	@CrossOrigin
	@DeleteMapping("/contracts/{contractId}/contractattributes/{contractAttributeId}")
    public ResponseEntity<?> deleteContractAttribute(@PathVariable (value = "contractId") Integer contractId,
                              @PathVariable (value = "contractAttributeId") Integer contractAttributeId) {
        return contractAttributeRepository.findByIdAndContractId(contractAttributeId, contractId).map(contractAttribute -> {
        	contractAttributeRepository.delete(contractAttribute);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ContractAttribute", "id", contractAttributeId));
    }	
}
