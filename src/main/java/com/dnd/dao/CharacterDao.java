package com.dnd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.beans.DndCharacter;

@Repository("characterDao")
public interface CharacterDao extends JpaRepository<DndCharacter, Integer>{
	
}
