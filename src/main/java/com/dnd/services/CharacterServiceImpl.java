package com.dnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dnd.beans.DndCharacter;
import com.dnd.dao.CharacterDao;

public class CharacterServiceImpl implements CharacterService {

	@Autowired
	CharacterDao characterDao;
	
	@Override
	public DndCharacter saveCharacter(DndCharacter character) {
		character.updateStats();	
		return characterDao.save(character);
	}

	@Override
	public DndCharacter updateCharacter(DndCharacter character) {
		return characterDao.save(character);
	}
	
	@Override
	public List<DndCharacter> getAllCharacters() {
		return characterDao.findAll();
	}

	@Override
	public DndCharacter getCharacterById(int id) {
		return characterDao.getOne(id);
	}

	@Override
	public DndCharacter getCharacterByName(String name) {
		return characterDao.getByName(name);
	}

	@Override
	public void removeCharacterById(int id) {
		characterDao.delete(characterDao.getOne(id));
	}

	@Override
	public List<DndCharacter> getCharactersByProfession(String profession) {
		return characterDao.getByProfession(profession);
	}

	@Override
	public List<DndCharacter> getCharactersByDeity(String deity) {
		return characterDao.getByDeity(deity);
	}

	@Override
	public List<DndCharacter> getCharactersByLocation(String location) {
		return characterDao.getByLocation(location);
	}
}
