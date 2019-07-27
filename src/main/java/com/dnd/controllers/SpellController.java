package com.dnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.Spell;
import com.dnd.services.SpellService;

@RestController
public class SpellController {

	@Autowired
	SpellService spellService;
	
	@RequestMapping(value = "spells", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Spell> getAllSpells() {
		return spellService.getAllSpells();
	}
}
