package com.dnd.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dnd.beans.Item;
import com.dnd.beans.Item;
import com.dnd.services.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@MockBean
	ItemService itemService;
	
	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	Item item;
	
	Logger logger = LoggerFactory.getLogger(ItemControllerTest.class);
	
	@Before
	public void init() {
		item = new Item(1, "name", "type", "an item");
	}
	
	@Test
	public void getAllItems() {
		List<Item> items = new ArrayList<>();
		items.add(item);
		
		Mockito.when(itemService.getAllItems()).thenReturn(items);
		
		try {
			mockMvc.perform(get("/items")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].itemName").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void createItem() {
		Mockito.when(itemService.addItem(Mockito.any(Item.class))).thenReturn(item);
		
		try {
			mockMvc.perform(post("/item")
					.content(om.writeValueAsString(item))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.itemName").value("name"))
					.andExpect(jsonPath("$.itemId").value("1"))
					.andExpect(jsonPath("$.description").value("an item"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void updateItem() {
		Mockito.when(itemService.addItem(Mockito.any(Item.class))).thenReturn(item);
		
		try {
			mockMvc.perform(put("/item")
					.content(om.writeValueAsString(item))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.itemName").value("name"))
					.andExpect(jsonPath("$.itemId").value("1"))
					.andExpect(jsonPath("$.description").value("an item"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getItemById() {
		Mockito.when(itemService.getItemById(1)).thenReturn(item);
		
		try {
			mockMvc.perform(get("/item/id/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.itemId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getItemByName() {
		Mockito.when(itemService.getItemByName("name")).thenReturn(item);
		
		try {
			mockMvc.perform(get("/item/name/name")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.itemId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getItemsBytype() {
		List<Item> items = new ArrayList<>();
		items.add(item);
		
		Mockito.when(itemService.getItemByType("type")).thenReturn(items);
		
		try {
			mockMvc.perform(get("/items/type/type")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].itemName").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
