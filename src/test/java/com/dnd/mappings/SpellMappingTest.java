package com.dnd.mappings;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dnd.beans.Spell;

public class SpellMappingTest {

	SpellMapping sm = new SpellMapping();
	
	@Test
	public void testSpellFromMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("spellId", 1);
		map.put("spellName", "a spell");
		
		Spell s = sm.SpellFromMap(map);
		
		assertEquals(s.getSpellId(), 1);
		assertEquals(s.getSpellName(), "a spell");
	}
}
