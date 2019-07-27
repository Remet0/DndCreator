package com.dnd.mappings;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.dnd.beans.Item;

public class ItemMapping {
	public Item itemFromMap(Map<String,Object> map) {
		Item i = new Item();
		i.setItemName((String)map.get("itemName"));
		i.setType((String)map.get("type"));
		i.setDescription((String)map.get("description"));
		if(map.containsKey("itemId")) {
			i.setItemId((int)map.get("itemId"));
		}
		return i;
	}
}
