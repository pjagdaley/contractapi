package com.sundeus.contract.model;

import java.io.Serializable;
import java.util.Date;

public class DashboardContract implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String contractName;
		
    private String contractType;

    private String status;
    
    private String createdBy;

    private Date createdDate;

	public Integer getId() {
		return id;
	}

	public String getContractName() {
		return contractName;
	}

	public String getContractType() {
		return contractType;
	}

	public String getStatus() {
		return status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}    
 }