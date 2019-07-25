package com.dnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dnd.beans.Spell;
import com.dnd.dao.SpellDao;

@Service("SpellServiceImpl")
@Transactional
public class SpellServiceImpl implements SpellService {

	@Autowired
	SpellDao spellDao;
	
	@Override
	public List<Spell> getAllSpells() {
		
		return spellDao.findAll();
	}

	@Override
	public Spell getSpellById(int id) {
		return spellDao.getOne(id);
	}

	@Override
	public Spell getSpellByName(String spellName) {
		return spellDao.getBySpellName(spellName);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Spell addSpell(Spell spell) {
		return spellDao.save(spell);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void removeSpellById(int spellId) {
		spellDao.deleteById(spellId);
	}

}
