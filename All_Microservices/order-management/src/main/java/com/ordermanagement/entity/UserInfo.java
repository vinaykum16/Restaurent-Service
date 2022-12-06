package com.ordermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	private long id;
	
	private String fullName;
	private String address;
	private String mobile;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public UserInfo(long id, String fullName, String address, String mobile) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.mobile = mobile;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
