package com.cognizant.truyum.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/{userId}")
	public Set<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException{
		return cartService.getAllCartItems(userId);
	}
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable(name="userId") final String userId, @PathVariable(name="menuItemId") final long menuItemId) throws MenuItemNotFoundException {
		cartService.addCartItem(userId, menuItemId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable(name="userId") final String userId, @PathVariable(name="menuItemId") final long menuItemId) throws MenuItemNotFoundException, CartEmptyException {
		cartService.removeCartItem(userId, menuItemId);
	}
}
