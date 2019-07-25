package com.dnd.mappings;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.dnd.beans.DndClass;

@Component
public class DndClassMapping {
	
	public DndClass DndClassFromMap(Map<String,Object> map) {
		DndClass c = new DndClass();
		c.setClassName((String)map.get("className"));
		if(map.containsKey("classId")) {
			c.setClassId((int)map.get("classId"));
		}	
		return c;
	}
}
