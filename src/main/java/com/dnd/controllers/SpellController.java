package com.dnd.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.Spell;
import com.dnd.services.SpellService;

@RestController
public class SpellController {

	Logger logger = LoggerFactory.getLogger(SpellController.class);
	
	@Autowired
	SpellService spellService;
	
	@RequestMapping(value = "spells", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Spell> getAllSpells() {
		return spellService.getAllSpells();
	}
	
	@RequestMapping(value = "spell", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Spell createSpell(@RequestBody Spell spell) {
		return spellService.addSpell(spell);
	}
	
	@RequestMapping(value = "spell", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Spell updateSpell(@RequestBody Spell spell) {
		return spellService.addSpell(spell);
	}
	
	@RequestMapping(value = "spell/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Spell getSpellById(@PathVariable int id) {
		Spell spell = spellService.getSpellById(id);
		return spell;
	}
	
	@RequestMapping(value = "spell/{name}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Spell getSpellByName(@PathVariable String name) {
		Spell spell = spellService.getSpellByName(name);
		return spell;
	}
}
