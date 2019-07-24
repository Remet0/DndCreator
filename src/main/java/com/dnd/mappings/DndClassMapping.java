package com.dnd.mappings;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.DndClass;

@Component
public class DndClassMapping {
	
	
	private Logger logger = LoggerFactory.getLogger(DndClassMapping.class);
	
	@Autowired
	private SpellMapping sm;
	
	public DndClass DndClassFromMap(Map<String,Object> map) {
		DndClass c = new DndClass();
		c.setClassName((String)map.get("className"));
		if(map.containsKey("classId")) {
			c.setClassId((int)map.get("classId"));
		}	
		return c;
	}
}
