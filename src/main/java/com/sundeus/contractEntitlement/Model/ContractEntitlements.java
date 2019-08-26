package com.sundeus.contractEntitlement.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sundeus.contract.model.Contract;

@Entity
@Table(name="ContractEntitlements")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContractEntitlements {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Contracts_Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Contract contract;
	
	@Column(name="Description")
	private String description;
	
	@NotNull
	@Column(name="ValidFromDate")
	private Date validFromDate;
	//validFromDate
	@NotNull
	@Column(name="ValidToDate")
	private Date validToDate;
	
	@NotNull
	@Column(name="PersonEmail")
	private String personEmail;
	
	@NotNull
	@Column(name="EntitlementType_Id")
    private int entitlementTypeId;
	
	@NotNull
	@Column(name="EntitlementTimeLine_Id")
	private int entitlementTimeLineId;
	
	@NotNull
	@Column(name="EntitlementFrequency_Id")
	private int entitlementFrequencyId;
	
	@NotNull
	@Column(name="EntitlementApproval_Id")
	private int entitlementApprovalId;
	
	@NotNull
	@Column(name="EntitlementReminderNotice_Id")
	private int entitlementReminderNoticeId;
	
	@Column(name="IsDeleted")
	private boolean isDeleted;

	
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Column(name="CreateDate")
	private Date createDate;
	
	@Column(name="UpdatedBy")
	private String updatedBy;
	
	@Column(name="UpdateDate")
	private Date updateDate;
	
	@Transient
	private String entitlementTypeName;
	
	@Transient
	private String entitlementFrequencyName;
	
	@Transient
	private String entitlementApprovalName;
	
	@Transient
	private String entitlementReminderNoticeName;
	
	@Transient
	private String entitlementTimeLineName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public int getEntitlementTypeId() {
		return entitlementTypeId;
	}

	public void setEntitlementTypeId(int entitlementTypeId) {
		this.entitlementTypeId = entitlementTypeId;
	}

	public int getEntitlementTimeLineId() {
		return entitlementTimeLineId;
	}

	public void setEntitlementTimeLineId(int entitlementTimeLineId) {
		this.entitlementTimeLineId = entitlementTimeLineId;
	}

	public int getEntitlementFrequencyId() {
		return entitlementFrequencyId;
	}

	public void setEntitlementFrequencyId(int entitlementFrequencyId) {
		this.entitlementFrequencyId = entitlementFrequencyId;
	}

	public int getEntitlementApprovalId() {
		return entitlementApprovalId;
	}

	public void setEntitlementApprovalId(int entitlementApprovalId) {
		this.entitlementApprovalId = entitlementApprovalId;
	}

	public int getEntitlementReminderNoticeId() {
		return entitlementReminderNoticeId;
	}

	public void setEntitlementReminderNoticeId(int entitlementReminderNoticeId) {
		this.entitlementReminderNoticeId = entitlementReminderNoticeId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getEntitlementTypeName() {
		return entitlementTypeName;
	}

	public void setEntitlementTypeName(String entitlementTypeName) {
		this.entitlementTypeName = entitlementTypeName;
	}

	public String getEntitlementFrequencyName() {
		return entitlementFrequencyName;
	}

	public void setEntitlementFrequencyName(String entitlementFrequencyName) {
		this.entitlementFrequencyName = entitlementFrequencyName;
	}

	public String getEntitlementApprovalName() {
		return entitlementApprovalName;
	}

	public void setEntitlementApprovalName(String entitlementApprovalName) {
		this.entitlementApprovalName = entitlementApprovalName;
	}

	public String getEntitlementReminderNoticeName() {
		return entitlementReminderNoticeName;
	}

	public void setEntitlementReminderNoticeName(String entitlementReminderNoticeName) {
		this.entitlementReminderNoticeName = entitlementReminderNoticeName;
	}	

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getEntitlementTimeLineName() {
		return entitlementTimeLineName;
	}

	public void setEntitlementTimeLineName(String entitlementTimeLineName) {
		this.entitlementTimeLineName = entitlementTimeLineName;
	}	
}
