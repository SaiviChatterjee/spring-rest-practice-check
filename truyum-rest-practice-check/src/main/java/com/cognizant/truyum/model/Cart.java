package com.cognizant.truyum.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	private Set<MenuItem> menuItemSet;
	private double total;
	public Cart() {
		this.menuItemSet=new HashSet<MenuItem>();
	}
	public Cart(Set<MenuItem> menuItemSet, double total) {
		super();
		this.menuItemSet = menuItemSet;
		this.total = total;
	}
	public Set<MenuItem> getMenuItemSet() {
		return menuItemSet;
	}
	public void setMenuItemSet(Set<MenuItem> menuItemSet) {
		this.menuItemSet = menuItemSet;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [menuItemSet=" + menuItemSet + ", total=" + total + "]";
	}
}
