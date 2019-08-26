package com.sundeus.contractEntitlement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundeus.contractEntitlement.Model.EntitlementReminderNotice;


@Repository
public interface EntitlementReminderNoticeRepository extends JpaRepository<EntitlementReminderNotice, Integer>{

	public Optional<EntitlementReminderNotice> getEntitlementReminderNoticeById(Integer id);
}
