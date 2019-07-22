package com.dnd.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPELLS")
public class Spell  implements Serializable{

	private static final long serialVersionUID = 8339374524240686230L;

	@Id
	@Column(name="spell_ID")
	private int spellId;
	
	@Column(name="spell_name")
	private String spellName;
	
	public Spell() {
		
	}

	public Spell(int spellId, String spellName) {
		super();
		this.spellId = spellId;
		this.spellName = spellName;
	}

	public int getSpellId() {
		return spellId;
	}

	public void setSpellId(int spellId) {
		this.spellId = spellId;
	}

	public String getSpellName() {
		return spellName;
	}

	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}

}
