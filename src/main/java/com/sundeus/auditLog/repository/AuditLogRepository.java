package com.sundeus.auditLog.repository;

import com.sundeus.auditLog.model.AuditLog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
	List<AuditLog> findByContractId(Integer contractId);
}