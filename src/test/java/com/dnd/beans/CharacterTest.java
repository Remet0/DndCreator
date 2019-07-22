package com.dnd.beans;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterTest {

	@Test
	public void test() {
		DndCharacter c = new DndCharacter();
		c.setStrength(10);
		c.setDexterity(10);
		c.setConstitution(10);
		c.setIntelligence(10);
		c.setWisdom(10);
		c.setCharisma(10);;

		Race r = new Race();
		r.setStrBonus(1);
		r.setDexBonus(2);
		r.setConBonus(3);
		r.setIntBonus(4);
		r.setWisBonus(5);
		r.setChaBonus(6);

		c.setRace(r);
		
		c.updateStats();
		
		assertEquals(c.getStrength(), 11);
		assertEquals(c.getDexterity(), 12);
		assertEquals(c.getConstitution(), 13);
		assertEquals(c.getIntelligence(), 14);
		assertEquals(c.getWisdom(), 15);
		assertEquals(c.getCharisma(), 16);
	}

}
