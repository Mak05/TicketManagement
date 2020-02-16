package com.mak.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	private String userName;
	private String password;
	private int assigneeId;
	
	public User(){}
	
	public User(String userName, String password, int assigneeId) {
		super();
		this.userName = userName;
		this.password = password;
		this.assigneeId = assigneeId;
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
	public int getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	  private Set<Authorities> authorities = new HashSet<>();
	@Override
	public String toString() {
		return "User [userName=" + userName + ", assigneeId=" + assigneeId + ", authorities=" + authorities + "]";
	}
}
