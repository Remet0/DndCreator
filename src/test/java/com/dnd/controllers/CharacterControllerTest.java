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

import com.dnd.beans.DndCharacter;
import com.dnd.services.CharacterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CharacterController.class)
public class CharacterControllerTest {


	@MockBean
	CharacterService characterService;
	
	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	DndCharacter character;
	
	Logger logger = LoggerFactory.getLogger(CharacterControllerTest.class);
	
	@Before
	public void init() {
		character = new DndCharacter();
		character.setName("name");
		character.setCharacterId(1);
		character.setDeity("deity");
		character.setProfession("profession");
		character.setLocation("location");
	}
	
	@Test
	public void getAllDndCharacters() {
		List<DndCharacter> characters = new ArrayList<>();
		characters.add(character);
		
		Mockito.when(characterService.getAllCharacters()).thenReturn(characters);
		
		try {
			mockMvc.perform(get("/characters")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].name").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void createDndCharacter() {
		Mockito.when(characterService.saveCharacter(Mockito.any(DndCharacter.class))).thenReturn(character);
		
		try {
			mockMvc.perform(post("/character")
					.content(om.writeValueAsString(character))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("name"))
					.andExpect(jsonPath("$.characterId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void updateDndCharacter() {
		Mockito.when(characterService.updateCharacter(Mockito.any(DndCharacter.class))).thenReturn(character);
		
		try {
			mockMvc.perform(put("/character")
					.content(om.writeValueAsString(character))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("name"))
					.andExpect(jsonPath("$.characterId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getDndCharacterById() {
		Mockito.when(characterService.getCharacterById(1)).thenReturn(character);
		
		try {
			mockMvc.perform(get("/character/id/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.characterId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getDndCharacterByName() {
		Mockito.when(characterService.getCharacterByName("name")).thenReturn(character);
		
		try {
			mockMvc.perform(get("/character/name/name")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.characterId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getCharactersByDeity() {
		List<DndCharacter> characters = new ArrayList<>();
		characters.add(character);
		
		Mockito.when(characterService.getCharactersByDeity("deity")).thenReturn(characters);
		
		try {
			mockMvc.perform(get("/characters/deity/deity")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].name").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getCharactersByLocation() {
		List<DndCharacter> characters = new ArrayList<>();
		characters.add(character);
		
		Mockito.when(characterService.getCharactersByLocation("location")).thenReturn(characters);
		
		try {
			mockMvc.perform(get("/characters/location/location")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].name").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getCharactersByProfession() {
		List<DndCharacter> characters = new ArrayList<>();
		characters.add(character);
		
		Mockito.when(characterService.getCharactersByProfession("profession")).thenReturn(characters);
		
		try {
			mockMvc.perform(get("/characters/profession/profession")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].name").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
