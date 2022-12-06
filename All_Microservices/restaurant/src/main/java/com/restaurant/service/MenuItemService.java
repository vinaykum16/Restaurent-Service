package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.MenuItem;

public interface MenuItemService {
	
	MenuItem addMenuItem(MenuItem menuItem);
	
	MenuItem getMenuItemByName(String name);
	
	List<MenuItem> getAllMenuItemByRestaurantId(long rId);
	
	void deleteMenuItemById(long mId);

}
