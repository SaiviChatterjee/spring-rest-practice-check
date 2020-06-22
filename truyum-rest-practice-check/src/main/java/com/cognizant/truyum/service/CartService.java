package com.cognizant.truyum.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException{
		cartDao.addCartItem(userId, menuItemId);
	}
	
	public Set<MenuItem> getAllCartItems(String userId) throws CartEmptyException{
		return cartDao.getAllCartItems(userId);
	}
	
	public void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException, CartEmptyException{
		cartDao.removeCartItem(userId, menuItemId);
	}
}
