package com.sundeus.contract.model;


import java.io.Serializable;

public class UIAttribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
			
	private Integer attributeId;
    
    private String attributeLabel;
    
    private String attributeValue;
    
    private Integer sectionId;
    
    private String sectionName;
	
	private Integer sequenceNo;

	public Integer getAttributeId() {
		return attributeId;
	}

	public String getAttributeLabel() {
		return attributeLabel;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public Integer getSequenceNo() {
		return sequenceNo;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public void setAttributeLabel(String attributeLabel) {
		this.attributeLabel = attributeLabel;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}        
}
