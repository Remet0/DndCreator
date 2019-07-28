package com.dnd.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dnd.beans.Spell;
import com.dnd.services.SpellService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(SpellController.class)
public class SpellControllerTest {

	@MockBean
	SpellService spellService;
	
	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	Logger logger = LoggerFactory.getLogger(SpellController.class);
	
	Spell spell;
	
	@Before
	public void init() {
		spell = new Spell(1, "name", "a spell");
	}
	
	@Test
	public void getAllSpells() {
		List<Spell> spells = new ArrayList<>();
		spells.add(new Spell("name"));
		
		Mockito.when(spellService.getAllSpells()).thenReturn(spells);
		
		try {
			mockMvc.perform(get("/spells")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].spellName").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void createSpell() {
		Mockito.when(spellService.addSpell(Mockito.any(Spell.class))).thenReturn(spell);
		
		try {
			mockMvc.perform(post("/spell")
					.content(om.writeValueAsString(spell))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.spellName").value("name"))
					.andExpect(jsonPath("$.spellId").value("1"))
					.andExpect(jsonPath("$.description").value("a spell"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void updateSpell() {
		
		Mockito.when(spellService.addSpell(Mockito.any(Spell.class))).thenReturn(spell);
		
		try {
			mockMvc.perform(put("/spell")
					.content(om.writeValueAsString(spell))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.spellName").value("name"))
					.andExpect(jsonPath("$.spellId").value("1"))
					.andExpect(jsonPath("$.description").value("a spell"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getSpellById() {
		Mockito.when(spellService.getSpellById(1)).thenReturn(spell);
		
		try {
			mockMvc.perform(get("/spell/id/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.spellId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getSpellByName() {
		Mockito.when(spellService.getSpellByName("name")).thenReturn(spell);
		
		try {
			mockMvc.perform(get("/spell/name/name")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.spellId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
