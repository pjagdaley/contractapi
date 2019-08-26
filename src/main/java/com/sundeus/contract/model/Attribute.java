package com.sundeus.contract.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Attributes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createDate", "updateDate"}, 
        allowGetters = true)
public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="ContractType_Id")
	private Integer contractTypeId;
		
	@Column(name="Section_Id")
	private Integer sectionId;
	
	@Column(name="MetaDataType_Id")
	private Integer metaDataTypeId;
	
	private String name;

	private String label;
	
	private String defaultValue;
	
    private Boolean isRequired;
    
    private Boolean isEditable;
    
    private Boolean isHidden;
    
    private String helpText;
    
    private Integer maxStringLength;
    
    private Integer minValue;
    
    private Integer maxValue;
    
    private Boolean isDependent;
    
    private Integer dependentOn;
    
    private Boolean isInherited;
    
    private String inheritedContractType;
    
    private String inheritedFrom;
    
    private Boolean isDisplaySummary;
    
    private Boolean isEditablePostExecution;
    
    private Boolean isSearchEnabled;
        
    private Integer sequenceNo;
    
    private Boolean isDeleted;
    
    private Integer updateCount;
        
    private String createdBy;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;
    
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

	public Integer getSectionId() {
		return sectionId;
	}

	public Integer getMetaDataTypeId() {
		return metaDataTypeId;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public Boolean getIsEditable() {
		return isEditable;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

	public String getHelpText() {
		return helpText;
	}

	public Integer getMaxStringLength() {
		return maxStringLength;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public Boolean getIsDependent() {
		return isDependent;
	}

	public Integer getDependentOn() {
		return dependentOn;
	}

	public Boolean getIsInherited() {
		return isInherited;
	}

	public String getInheritedContractType() {
		return inheritedContractType;
	}

	public String getInheritedFrom() {
		return inheritedFrom;
	}

	public Boolean getIsDisplaySummary() {
		return isDisplaySummary;
	}

	public Boolean getIsEditablePostExecution() {
		return isEditablePostExecution;
	}

	public Boolean getIsSearchEnabled() {
		return isSearchEnabled;
	}

	public Integer getSequenceNo() {
		return sequenceNo;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
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

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public void setMetaDataTypeId(Integer metaDataTypeId) {
		this.metaDataTypeId = metaDataTypeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public void setMaxStringLength(Integer maxStringLength) {
		this.maxStringLength = maxStringLength;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public void setIsDependent(Boolean isDependent) {
		this.isDependent = isDependent;
	}

	public void setDependentOn(Integer dependentOn) {
		this.dependentOn = dependentOn;
	}

	public void setIsInherited(Boolean isInherited) {
		this.isInherited = isInherited;
	}

	public void setInheritedContractType(String inheritedContractType) {
		this.inheritedContractType = inheritedContractType;
	}

	public void setInheritedFrom(String inheritedFrom) {
		this.inheritedFrom = inheritedFrom;
	}

	public void setIsDisplaySummary(Boolean isDisplaySummary) {
		this.isDisplaySummary = isDisplaySummary;
	}

	public void setIsEditablePostExecution(Boolean isEditablePostExecution) {
		this.isEditablePostExecution = isEditablePostExecution;
	}

	public void setIsSearchEnabled(Boolean isSearchEnabled) {
		this.isSearchEnabled = isSearchEnabled;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	}
