package com.dnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.DndCharacter;
import com.dnd.services.CharacterService;

@RestController
public class CharacterController {

	@Autowired
	private CharacterService characterService;
	
	@RequestMapping(value = "/characters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DndCharacter> getAllCharacters() {
		return characterService.getAllCharacters();
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public DndCharacter createCharacter(@RequestBody DndCharacter character) {
		return characterService.saveCharacter(character);
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public DndCharacter updateCharacter(@RequestBody DndCharacter character) {
		return characterService.updateCharacter(character);
	}
	
	@RequestMapping(value = "/character/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DndCharacter getCharacterById(@PathVariable int id) {
		return characterService.getCharacterById(id);
	}
	
	@RequestMapping(value = "/character/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DndCharacter getCharacterByName(@PathVariable String name) {
		return characterService.getCharacterByName(name);
	}
	
	@RequestMapping(value = "/characters/deity/{deity}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DndCharacter> getCharactersByDeity(@PathVariable String deity) {
		return characterService.getCharactersByDeity(deity);
	}
	
	@RequestMapping(value = "/characters/location/{location}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DndCharacter> getCharactersByLocation(@PathVariable String location) {
		return characterService.getCharactersByLocation(location);
	}
	
	@RequestMapping(value = "/characters/profession/{profession}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DndCharacter> getCharactersByProfession(@PathVariable String profession) {
		return characterService.getCharactersByProfession(profession);
	}
}
