package com.sundeus.auditLog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "AuditLog")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createDate"}, 
        allowGetters = true)
public class AuditLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull
	@Column(name="contract_Id")
	private Integer contractId;
	
	@NotBlank
	private String action;
	
	private String createdBy;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

	public Integer getId() {
		return id;
	}

	public Integer getContractId() {
		return contractId;
	}

	public String getAction() {
		return action;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}