package com.dnd.mappings;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.dnd.beans.Item;

@Component
public class ItemMapping {
	public Item itemFromMap(Map<String,Object> map) {
		Item i = new Item();
		i.setName((String)map.get("itemName"));
		i.setType((String)map.get("type"));
		i.setDescription((String)map.get("description"));
		if(map.containsKey("id")) {
			i.setItemId((int)map.get("itemId"));
		}
		return i;
	}
}
