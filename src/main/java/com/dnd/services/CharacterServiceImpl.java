package com.dnd.services;

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

}
