package com.dnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.beans.Spell;

@Repository("spellDao")
public interface SpellDao extends JpaRepository<Spell, Integer> {
	public List<Spell> findAll();
}
