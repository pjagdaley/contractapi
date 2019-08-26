package com.sundeus.contractEntitlement.EntitlementController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sundeus.contract.exception.ResourceNotFoundException;
import com.sundeus.contract.repository.ContractRepository;
import com.sundeus.contractEntitlement.Model.ContractEntitlements;
import com.sundeus.contractEntitlement.Model.EntitlementApproval;
import com.sundeus.contractEntitlement.Model.EntitlementFrequency;
import com.sundeus.contractEntitlement.Model.EntitlementReminderNotice;
import com.sundeus.contractEntitlement.Model.EntitlementTimeLines;
import com.sundeus.contractEntitlement.Model.EntitlementType;
import com.sundeus.contractEntitlement.Repository.ContractEntitlementRepository;
import com.sundeus.contractEntitlement.Repository.EntitlementApprovalRepository;
import com.sundeus.contractEntitlement.Repository.EntitlementFrequencyRepository;
import com.sundeus.contractEntitlement.Repository.EntitlementReminderNoticeRepository;
import com.sundeus.contractEntitlement.Repository.EntitlementTimeLineRepository;
import com.sundeus.contractEntitlement.Repository.EntitlmentTypeRepository;


@RestController
@RequestMapping("/api")
public class EntitlementController {
	
	@Autowired
    ContractRepository contractRepository;
	@Autowired
	ContractEntitlementRepository contractEntitlementRepository;
	@Autowired
	EntitlmentTypeRepository  entitlementTypeRepository;
	@Autowired
	EntitlementTimeLineRepository entitlmentTimeLinesRepository;
	@Autowired
	EntitlementReminderNoticeRepository entitlementReminderNoticeRepository;
	@Autowired
	EntitlementFrequencyRepository entitlementFrequencyRepository;
	@Autowired
	EntitlementApprovalRepository entitlementApprovalRepository;
	
	
	@GetMapping("/entitlementTypes")
	public List<EntitlementType> getEntitlementTypes(){
		return entitlementTypeRepository.findAll();
	}
	///////////////
	@GetMapping("/entitlementTimeLines")
	public List<EntitlementTimeLines> getEntilementTimeLines(){
		return entitlmentTimeLinesRepository.findAll();
		}
   ///////////////
	@GetMapping("/entitlementReminderNotices")
	public List<EntitlementReminderNotice> getEntitlementReminderNotices(){
		return entitlementReminderNoticeRepository.findAll();
		}
	/////////////
	@GetMapping("/entitlementFrequencies")
	public List<EntitlementFrequency> getEntitlementFrequency(){
		return entitlementFrequencyRepository.findAll();
		}
	///////////
	@GetMapping("/entitlementApprovals")
	public List<EntitlementApproval> getEntitlementApproval(){
		return entitlementApprovalRepository.findAll();
		}
	//////////ontra
	@GetMapping("/contractEntitlements")
	public List<ContractEntitlements> getAllContractEntitlements() {
		
		List<ContractEntitlements> list= contractEntitlementRepository.findAll();
		for(ContractEntitlements ent : list) {
			Optional<EntitlementType> entitlementType=entitlementTypeRepository.getEntitlementTypeById(ent.getEntitlementTypeId());
			ent.setEntitlementTypeName(entitlementType.get().getName());
			Optional<EntitlementFrequency> entitlementFrequency=entitlementFrequencyRepository.getEntitlementFrequencyById(ent.getEntitlementFrequencyId());
		    ent.setEntitlementFrequencyName(entitlementFrequency.get().getName());
		    Optional<EntitlementApproval> entitlementApproval=entitlementApprovalRepository.getEntitlementApprovalById(ent.getEntitlementApprovalId());
		    ent.setEntitlementApprovalName(entitlementApproval.get().getName());
		    Optional<EntitlementReminderNotice> entitlementReminderNotice=entitlementReminderNoticeRepository.getEntitlementReminderNoticeById(ent.getEntitlementReminderNoticeId());
		    ent.setEntitlementReminderNoticeName(entitlementReminderNotice.get().getName());
		    Optional<EntitlementTimeLines> entitlementTimeLines=entitlmentTimeLinesRepository.getEntitlementTimeLineById(ent.getEntitlementTimeLineId());
		    ent.setEntitlementTimeLineName(entitlementTimeLines.get().getName());
		    
		}
		return list;
	}
	////////////
	@PostMapping("/contracts/{contractId}/contractEntitlements")	
	public List<ContractEntitlements> createcontractEntitlement(@PathVariable (value = "contractId") Integer contractId,
											@RequestBody List<ContractEntitlements> contractEntitlements) {
		
		return contractRepository.findById(contractId).map(contract -> {			
			contractEntitlements.forEach(contractEntitlement -> contractEntitlement.setContract(contract));
        	return contractEntitlementRepository.saveAll(contractEntitlements);
        }).orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));						
		
	}
	
	
	@PutMapping("/contracts/{contractId}/contractEntitlements/{id}")
	public ContractEntitlements updatecontractEntitlement(@PathVariable (value = "contractId") Integer contractId,
														@PathVariable(value = "contractEntitlementId") Integer contractEntitlementId,
															@RequestBody ContractEntitlements contractEntitlement) {
		
		 if(!contractRepository.existsById(contractId)) {
	            throw new ResourceNotFoundException("Contract", "id", contractId);
	        }
		 
		 return contractEntitlementRepository.findById(contractEntitlementId).map(contractEntitlements -> {
			 
			 	contractEntitlements.setDescription(contractEntitlement.getDescription());
				contractEntitlements.setValidFromDate(contractEntitlement.getValidFromDate());
				contractEntitlements.setValidToDate(contractEntitlement.getValidToDate());
				contractEntitlements.setPersonEmail(contractEntitlement.getPersonEmail());
				contractEntitlements.setEntitlementTypeId(contractEntitlement.getEntitlementTypeId());
				contractEntitlements.setEntitlementTimeLineId(contractEntitlement.getEntitlementTimeLineId());
				contractEntitlements.setEntitlementFrequencyId(contractEntitlement.getEntitlementFrequencyId());
				contractEntitlements.setEntitlementApprovalId(contractEntitlement.getEntitlementApprovalId());
				contractEntitlements.setEntitlementReminderNoticeId(contractEntitlement.getEntitlementReminderNoticeId());
				contractEntitlements.setDeleted(contractEntitlement.isDeleted());
				contractEntitlements.setCreatedBy(contractEntitlement.getCreatedBy());
				contractEntitlements.setCreateDate(contractEntitlement.getCreateDate());
				contractEntitlements.setUpdatedBy(contractEntitlement.getUpdatedBy());
				contractEntitlements.setUpdateDate(contractEntitlement.getUpdateDate());				
				return contractEntitlementRepository.save(contractEntitlements);   
	        }).orElseThrow(() -> new ResourceNotFoundException("ContractEntitlements", "id", contractEntitlementId));
 	}	
	
}	
