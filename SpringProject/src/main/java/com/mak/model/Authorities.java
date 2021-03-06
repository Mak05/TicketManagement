package com.mak.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Authorities {
	
	@Id
	private String authority;
	@ManyToOne
	@JoinColumn(name = "userName")
	private User user;
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	
}
