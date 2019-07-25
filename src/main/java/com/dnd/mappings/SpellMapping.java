package com.dnd.mappings;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.dnd.beans.Spell;

@Component
public class SpellMapping {
	
	public Spell SpellFromMap(Map<String,Object> map) {
		Spell s = new Spell();
		s.setSpellName((String)map.get("spellName"));
		s.setDescription((String)map.get("description"));
		if(map.containsKey("id")) {
			s.setSpellId((int)map.get("spellId"));
		}
		return s;
	}
}
