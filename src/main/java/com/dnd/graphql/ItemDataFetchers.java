package com.dnd.graphql;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.Item;
import com.dnd.mappings.ItemMapping;
import com.dnd.services.ItemService;

import graphql.schema.DataFetcher;

@Component
public class ItemDataFetchers {

	@Autowired
	private ItemMapping im;
	
	@Autowired
	private ItemService itemService;

	
	Logger logger = LoggerFactory.getLogger(ItemDataFetchers.class);
	
	
	public DataFetcher<List<Item>> getAllItemsDataFetcher() {
		return dataFetchingEnvironment -> {
			return itemService.getAllItems();
		};
	}
	
	public DataFetcher<Item> getItemByNameDataFetcher() {
		return dataFetchingEnvironment -> {
			String name = dataFetchingEnvironment.getArgument("itemName");
			return itemService.getItemByName(name);
		};
	}

	public DataFetcher<Item> getItemByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			int id = dataFetchingEnvironment.getArgument("itemId");
			return itemService.getItemById(id);
		};
	}

	public DataFetcher<Item> getItemByTypeDataFetcher() {
		return dataFetchingEnvironment -> {
			String type = dataFetchingEnvironment.getArgument("type");
			return itemService.getItemByType(type);
		};
	}
	
	public DataFetcher<Item> createItemDataFetcher() {
		return dataFetchingEnvironment -> {
			Map<String, Object> dndClass = dataFetchingEnvironment.getArgument("item");
			Item c = im.itemFromMap(dndClass);
			return itemService.addItem(c);
		};
	}
	
	public DataFetcher<Integer> removeItemDataFetcher() {
		return dataFetchingEnvironment -> {
			int id = dataFetchingEnvironment.getArgument("itemId");
			itemService.removeItemByid(id);
			return id;
		};
	}
}
