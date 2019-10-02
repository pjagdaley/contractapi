package com.sundeus.contract.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Contracts")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createDate", "updateDate"}, 
        allowGetters = true)
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="contractType_id")
	private Integer contractTypeId;
	
	@Transient
	private String contractTypeName;
	
	@Column(name="transactionType_id")
	//@NotNull
	private Integer transactionTypeId;
	
	@Transient
	private String transactionTypeName;

    @NotBlank
    private String name;

    private String reason;
    
    @NotNull
    private Double version;
    
    @Column(name="template_Id")
	private Integer templateId;
    
    private String DocumentId;
    
    @Column(name="status_Id")
    private Integer statusId;
    
    @Transient
	private String statusName;
    
    private Boolean aiEnabled;
    
    private Boolean isMandatoryFilled;
    
    private Boolean isGenerated;
    
    private Boolean isDeleted;
    
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer updateCount;
    
    private Integer completedStep;
    
    private String createdBy;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;
    
    //@Column(name="updatedBy")
    private String updatedBy;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateDate;

	public Integer getId() {
		return id;
	}

	public Integer getContractTypeId() {
		return contractTypeId;
	}

	public Integer getTransactionTypeId() {
		return transactionTypeId;
	}

	public String getName() {
		return name;
	}

	public String getReason() {
		return reason;
	}

	public Double getVersion() {
		return version;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public Integer getStatusId() {
		return statusId;
	}
	
	public Boolean getAiEnabled() {
		return aiEnabled;
	}

	public Integer getUpdateCount() {
		return updateCount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public void setTransactionTypeId(Integer transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	public void setAiEnabled(Boolean aiEnabled) {
		this.aiEnabled = aiEnabled;
	}	

	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsMandatoryFilled() {
		return isMandatoryFilled;
	}

	public void setIsMandatoryFilled(Boolean isMandatoryFilled) {
		this.isMandatoryFilled = isMandatoryFilled;
	}

	public String getDocumentId() {
		return DocumentId;
	}

	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}
	
	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public Integer getCompletedStep() {
		return completedStep;
	}

	public void setCompletedStep(Integer completedStep) {
		this.completedStep = completedStep;
	}

	public Boolean getIsGenerated() {
		return isGenerated;
	}

	public void setIsGenerated(Boolean isGenerated) {
		this.isGenerated = isGenerated;
	}		
}
