package com.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItem {
	
	@Id
	@Column(name="menu_id")
	private long id;
	
	@Column(name="restaurant_id")
	private long restaId;
	
	@Column(name="menu_name")
	private String name;
	
	private double price;

	public long getId() {
		return id;
	}

	public void setmId(long id) {
		this.id = id;
	}

	public long getRestaId() {
		return restaId;
	}

	public void setRestaId(long restaId) {
		this.restaId = restaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuItem(long id, long restaId, String name, double price) {
		super();
		this.id = id;
		this.restaId = restaId;
		this.name = name;
		this.price = price;
	}

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
