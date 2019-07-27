package com.dnd.services;

import java.util.List;

import com.dnd.beans.Item;

public interface ItemService {
	
	public List<Item> getAllItems();
	public Item getItemById(int id);
	public Item getItemByName(String name);
	public List<Item> getItemByType(String type);
	public Item addItem(Item item);
	public void removeItemByid(int id);
}
