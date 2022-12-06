package com.ordermanagement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@Id
	private long id;
	
	private long restaId;
	
	@OneToMany
	private List<FoodItem> foodItems;
	
	private int totalPrice;
	
	private long paymentId;
	
	@OneToOne
	private UserInfo userinfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRestaId() {
		return restaId;
	}

	public void setRestaId(long restaId) {
		this.restaId = restaId;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public OrderDetails(long id, long restaId, List<FoodItem> foodItems, int totalPrice, long paymentId,
			UserInfo userinfo) {
		super();
		this.id = id;
		this.restaId = restaId;
		this.foodItems = foodItems;
		this.totalPrice = totalPrice;
		this.paymentId = paymentId;
		this.userinfo = userinfo;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
