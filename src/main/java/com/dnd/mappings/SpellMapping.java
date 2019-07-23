package com.dnd.mappings;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.Spell;
import com.dnd.services.SpellService;

@Component
public class SpellMapping {
	
	@Autowired
	private SpellService spellService;
	
	public Spell SpellFromMap(Map<String,Object> map) {
		Spell s = new Spell();
		s.setSpellName((String)map.get("spellName"));
		if(map.containsKey("spellId")) {
			s.setSpellId((int)map.get("spellId"));
		}
		return spellService.addSpell(s);
	}
}
