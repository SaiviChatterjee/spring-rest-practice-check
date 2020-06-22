package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Repository
public class CartDaoCollectionImpl implements CartDao {
	
	@Autowired
	private MenuItemService menuItemService;
	
	private Map<String,Cart> carts;

	public CartDaoCollectionImpl() {
		carts=new HashMap<String, Cart>();
	}

	@Override
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		MenuItem menuItem=menuItemService.getMenuItem(menuItemId);
		if(carts.containsKey(userId)) {
			Cart userCart=carts.get(userId);
			userCart.getMenuItemSet().add(menuItem);
			userCart.setTotal(userCart.getTotal()+menuItem.getPrice());
			carts.put(userId, userCart);
		}else {
			Cart userCart=new Cart();
			userCart.getMenuItemSet().add(menuItem);
			userCart.setTotal(menuItem.getPrice());
		    carts.put(userId, userCart);
		}
	}

	@Override
	public Set<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		if(carts.containsKey(userId)) {
			return carts.get(userId).getMenuItemSet();
		}
		throw new CartEmptyException();
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException, CartEmptyException {
		MenuItem menuItem=menuItemService.getMenuItem(menuItemId);
		if(carts.containsKey(userId)) {
			Cart userCart=carts.get(userId);
			userCart.getMenuItemSet().remove(menuItem);
			userCart.setTotal(userCart.getTotal()-menuItem.getPrice());
			carts.put(userId, userCart);
			return;
		}
		throw new CartEmptyException();
	}

}
