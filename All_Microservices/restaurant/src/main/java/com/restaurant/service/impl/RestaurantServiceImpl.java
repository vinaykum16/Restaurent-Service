package com.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Restaurant;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private RestaurantRepository restaRepo;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restRepo) {
		this.restaRepo=restRepo;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaRepo.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		return restaRepo.findByName(name);
	}

	@Override
	public Restaurant getRestaurantByLocation(String location) {
		return restaRepo.findByLocation(location);
	}

	@Override
	public List<Restaurant> getAllRestaurantList() {
		return restaRepo.findAll();
	}

	@Override
	public void deleteRestaurantById(long id) {
		restaRepo.deleteById(id);
	}

	@Override
	public Restaurant getRestaurantById(long id) {
		return restaRepo.findById(id).orElse(null);
	}

}
