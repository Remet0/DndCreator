package com.dnd.mappings;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dnd.beans.DndClass;
import com.dnd.beans.Spell;

public class DndClassMappingTest {

	DndClassMapping dcm = new DndClassMapping();
	
	@Test
	public void testDndClassFromMap() {
		
		Map<String, Object> dndClass = new HashMap<>();
		dndClass.put("classId", 1);
		dndClass.put("className", "a class");
		
		DndClass dc = dcm.DndClassFromMap(dndClass);
		
		assertEquals(dc.getClassId(), 1);
		assertEquals(dc.getClassName(), "a class");
	}

}
