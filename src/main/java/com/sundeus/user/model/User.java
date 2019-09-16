package com.sundeus.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;


@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createDate", "updateDate"}, 
        allowGetters = true)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank
	private String employeeId;
	
	@NotBlank
	private String firstName;
	private String middleName;
	
	@NotBlank
	private String lastName;
	private String address;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String emailAddress;
	private String password;
	private String contactNumber;
	
	//private Blob profilePic;
	@Lob
	private byte[] profilePic;
	@NotBlank
	private String designation;
	
	@NotBlank
	private String organizationLevel;
	
	@NotBlank
	private String department;
	private Date dateOfJoining;
	
	@NotBlank
	private String reportingManager;
	
	@NotNull
	@Column(name="role_Id")
	private Integer roleId;
	    
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

	public String getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCountry() {
		return country;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public String getDesignation() {
		return designation;
	}

	public String getOrganizationLevel() {
		return organizationLevel;
	}

	public String getDepartment() {
		return department;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public String getReportingManager() {
		return reportingManager;
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

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setOrganizationLevel(String organizationLevel) {
		this.organizationLevel = organizationLevel;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}	
}
