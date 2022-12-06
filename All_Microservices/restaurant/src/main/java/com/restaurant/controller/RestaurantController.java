package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.MenuItem;
import com.restaurant.entity.Restaurant;
import com.restaurant.service.impl.MenuItemServiceImpl;
import com.restaurant.service.impl.RestaurantServiceImpl;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	private MenuItemServiceImpl menuService;
	
	private RestaurantServiceImpl restaService;
	
	@Autowired
	public RestaurantController(MenuItemServiceImpl menuService, RestaurantServiceImpl restaService) {
		this.menuService = menuService;
		this.restaService = restaService;
	}
	
	@PostMapping("/add")
	public Restaurant addNewRestaurant(@RequestBody Restaurant restaurant) {
		return restaService.addRestaurant(restaurant);
	}
	
	@GetMapping("/all")
	public List<Restaurant> getAllRestaurants(){
		return restaService.getAllRestaurantList();
	}
	
	@GetMapping("/{id}")
	public Restaurant findRestaurantById(@PathVariable("id") long id) {
		return restaService.getRestaurantById(id);
	}
	
	@GetMapping("/name/{name}")
	public Restaurant findRestaurantByName(@PathVariable("name") String name) {
		return restaService.getRestaurantByName(name);
	}
	
	@GetMapping("/location/{location}")
	public Restaurant findRestaurantByLocation(@PathVariable("location") String location) {
		return restaService.getRestaurantByLocation(location);
	}
	
	@DeleteMapping("/delete/id/{id}")
	public void deleteRestaById(@PathVariable("id") long id) {
		restaService.deleteRestaurantById(id);
	}
	
	@PostMapping("/menuitem/add")
	public MenuItem saveNewMenuItem(@RequestBody MenuItem menuItem) {
		return menuService.addMenuItem(menuItem);
	}
	
	
	@GetMapping("/menuitem/{name}")
	public MenuItem findMenuItemByName(@PathVariable("name") String name) {
		return menuService.getMenuItemByName(name);
	}
	
	@GetMapping("/withmenu/{restaId}")
	public List<MenuItem> findMenuItemByRestaurantId(@PathVariable("restaId") long restaId){
		return menuService.getAllMenuItemByRestaurantId(restaId);
	}
	
	@DeleteMapping("/deleteitem/id/{id}")
	public void deleteMenuItemById(@PathVariable("id") long id) {
		menuService.deleteMenuItemById(id);
	}

}
