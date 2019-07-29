package com.dnd.services;

import java.util.List;

import com.dnd.beans.DndCharacter;

public interface CharacterService {
	public DndCharacter saveCharacter(DndCharacter character);
	public DndCharacter updateCharacter(DndCharacter character);
	public List<DndCharacter> getAllCharacters();
	public DndCharacter getCharacterById(int id);
	public DndCharacter getCharacterByName(String name);
	public void removeCharacterById(int id);
	public List<DndCharacter> getCharactersByProfession(String profession);
	public List<DndCharacter> getCharactersByDeity(String deity);
	public List<DndCharacter> getCharactersByLocation(String location);
}
