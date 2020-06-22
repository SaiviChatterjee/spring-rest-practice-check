package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static ArrayList<MenuItem> MENU_ITEM_LIST;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	
	public MenuItemDaoCollectionImpl() {
		ApplicationContext context=new ClassPathXmlApplicationContext("truyum.xml");
		MENU_ITEM_LIST=(ArrayList<MenuItem>)context.getBean("menuItemList");
		LOGGER.debug("MenuItemList: {}",MENU_ITEM_LIST);
	}

	@Override
	public List<MenuItem> getMenuListAdmin() {
		return MENU_ITEM_LIST;
	}

	@Override
	public List<MenuItem> getMenuListCustomer() {
		List<MenuItem> customerMenuList=new ArrayList<MenuItem>();
		for(MenuItem menuItem:MENU_ITEM_LIST) {
			if(menuItem.isActive()) {
				customerMenuList.add(menuItem);
			}
		}
		return customerMenuList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) throws MenuItemNotFoundException {
		for(MenuItem menuItem:MENU_ITEM_LIST) {
			if(menuItem.getId()==menuItemId) {
				return menuItem;
			}
		}
		throw new MenuItemNotFoundException();
	}

	@Override
	public MenuItem save(MenuItem menuItem) throws MenuItemNotFoundException {
		for(int i=0;i<MENU_ITEM_LIST.size();i++) {
			if(MENU_ITEM_LIST.get(i).getId()==menuItem.getId()) {
				MENU_ITEM_LIST.set(i,menuItem);
				return menuItem;
			}
		}
		throw new MenuItemNotFoundException();
	}
	
}
