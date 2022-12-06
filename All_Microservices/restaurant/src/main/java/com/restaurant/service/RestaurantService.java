package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant addRestaurant(Restaurant restaurant);
	
	Restaurant getRestaurantByName(String name);
	
	Restaurant getRestaurantByLocation(String location);
	
	Restaurant getRestaurantById(long id);
	
	List<Restaurant> getAllRestaurantList();
	
	void deleteRestaurantById(long rId);

}
