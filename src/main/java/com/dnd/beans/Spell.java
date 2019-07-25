package com.dnd.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="SPELLS")
public class Spell  implements Serializable{

	private static final long serialVersionUID = 8339374524240686230L;

	@Id
	@GeneratedValue(generator = "SPELL_SEQ", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name="SPELL_SEQ", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={
			@Parameter(name="sequence_name", value="SPELL_SEQ"),
			@Parameter(name="initial_value",value="5"),
			@Parameter(name="increment_size",value="1")
	})
	@Column(name="spell_ID")
	private int spellId;
	
	@Column(name="spell_name")
	private String spellName;
	
	@Column(name="description")
	private String description;
	
	public Spell() {
		
	}

	public Spell(int spellId, String spellName, String description) {
		super();
		this.spellId = spellId;
		this.spellName = spellName;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Spell [spellId=" + spellId + ", spellName=" + spellName + ", description=" + description + "]";
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Spell( String spellName) {
		super();
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
