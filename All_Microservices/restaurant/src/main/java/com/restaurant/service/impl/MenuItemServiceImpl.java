package com.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.MenuItem;
import com.restaurant.repository.MenuItemRepository;
import com.restaurant.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	private MenuItemRepository menuRepo;
	
	@Autowired
	public MenuItemServiceImpl(MenuItemRepository menuRepo) {
		this.menuRepo=menuRepo;
	}

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		return menuRepo.save(menuItem);
	}


	@Override
	public MenuItem getMenuItemByName(String name) {
		return menuRepo.findByName(name);
	}

	@Override
	public List<MenuItem> getAllMenuItemByRestaurantId(long restaId) {
		return menuRepo.findByRestaId(restaId);
	}

	@Override
	public void deleteMenuItemById(long id) {
		menuRepo.deleteById(id);
	}

}
