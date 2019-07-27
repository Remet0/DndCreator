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

	private ItemMapping im = new ItemMapping();
	
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

	public DataFetcher<List<Item>> getItemByTypeDataFetcher() {
		return dataFetchingEnvironment -> {
			String type = dataFetchingEnvironment.getArgument("type");
			return itemService.getItemByType(type);
		};
	}
	
	public DataFetcher<Item> createItemDataFetcher() {
		return dataFetchingEnvironment -> {
			Map<String, Object> item = dataFetchingEnvironment.getArgument("item");
			Item i = im.itemFromMap(item);
			
			i = itemService.addItem(i);
			
			return i;
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
