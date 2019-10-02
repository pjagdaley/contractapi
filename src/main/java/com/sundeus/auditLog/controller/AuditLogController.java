package com.sundeus.auditLog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sundeus.auditLog.model.AuditLog;
import com.sundeus.auditLog.repository.AuditLogRepository;
import com.sundeus.contract.model.ContractAttribute;
import com.sundeus.contract.repository.ContractRepository;
import com.sundeus.role.exception.ResourceNotFoundException;
import com.sundeus.role.model.Role;
import com.sundeus.user.exception.UserNotFoundException;
import com.sundeus.user.model.User;
import com.sundeus.user.model.UserDetails;
import com.sundeus.user.repository.UserRepository;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuditLogController {

	@Autowired
	AuditLogRepository auditLogRepository;
	
	@Autowired
    ContractRepository contractRepository;
	
	//Get All AuditLogs
	@GetMapping("/{contractId}/auditlogs")
	public List<AuditLog> getAuditLogs(@PathVariable (value = "contractId") Integer contractId) {
	    return auditLogRepository.findByContractId(contractId);
	}	
	
	//Create a new AuditLogs
	@CrossOrigin
	@PostMapping("/{contractId}/auditlogs")
	public AuditLog createAuditLog(@PathVariable (value = "contractId") Integer contractId,
            @Valid @RequestBody AuditLog auditlogs) {
		
		contractRepository.findById(contractId).orElseThrow(() -> new ResourceNotFoundException("Contract", "id", contractId));
		
		auditlogs.setCreateDate(new Date());
		auditlogs.setContractId(contractId);					
		
	    return auditLogRepository.save(auditlogs);
	}	
}