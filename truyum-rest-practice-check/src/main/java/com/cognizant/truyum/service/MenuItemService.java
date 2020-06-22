package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuListAdmin() {
		return menuItemDao.getMenuListAdmin();
	}

	public List<MenuItem> getMenuListCustomer() {
		return menuItemDao.getMenuListCustomer();
	}

	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}
	
	public MenuItem getMenuItem(Long menuItemId) throws MenuItemNotFoundException {
		return menuItemDao.getMenuItem(menuItemId);
	}

	public MenuItem save(MenuItem menuItem) throws MenuItemNotFoundException {
		return menuItemDao.save(menuItem);
	}
}
