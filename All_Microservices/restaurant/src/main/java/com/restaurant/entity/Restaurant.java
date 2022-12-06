package com.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurant {
	
	@Id
	@Column(name ="restaurant_id")
	private long id;
	
	@Column(name ="restaurant_name")
	private String name;
	
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Restaurant(long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

}
