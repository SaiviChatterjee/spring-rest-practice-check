package com.cognizant.truyum.dao;

import java.io.IOException;
import java.util.List;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuListAdmin();
	public List<MenuItem> getMenuListCustomer();
	public void modifyMenuItem(MenuItem menuItem);
	public MenuItem getMenuItem(Long menuItemId) throws MenuItemNotFoundException;
	public MenuItem save(MenuItem menuItem) throws MenuItemNotFoundException;
}
