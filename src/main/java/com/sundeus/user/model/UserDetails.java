package com.sundeus.user.model;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

public class UserDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String emailAddress;
	
	@NotBlank	
	private String password;
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
