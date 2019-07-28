package com.dnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.Item;
import com.dnd.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@RequestMapping(value = "item", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item createItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@RequestMapping(value = "items", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item updateItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@RequestMapping(value = "item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item getItembyId(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@RequestMapping(value = "item/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item getItembyName(@PathVariable String name) {
		return itemService.getItemByName(name);
	}
	
	@RequestMapping(value = "item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getItembyType(@PathVariable String type) {
		return itemService.getItemByType(type);
	}
}
