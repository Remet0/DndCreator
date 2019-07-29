package com.dnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.beans.DndCharacter;

@Repository("characterDao")
public interface CharacterDao extends JpaRepository<DndCharacter, Integer>{
	public List<DndCharacter> findAll();
	public DndCharacter getByName(String name);
	public List<DndCharacter> getByDeity(String deity);
	public List<DndCharacter> getByProfession(String profession);
	public List<DndCharacter> getByLocation(String location);
}
