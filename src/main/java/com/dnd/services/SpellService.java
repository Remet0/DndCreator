package com.dnd.services;

import java.util.List;

import com.dnd.beans.Spell;

public interface SpellService {
	public List<Spell> getAllSpells();
	public Spell addSpell(Spell spell);
	public Spell getSpellById(int id);
}
