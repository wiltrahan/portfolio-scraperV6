package com.portfolioscraper.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScrapeUser {

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;

	public ScrapeUser() {
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
