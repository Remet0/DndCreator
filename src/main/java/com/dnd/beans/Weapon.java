package com.dnd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="WEAPON")
public class Weapon {
	@Id
	@GeneratedValue(generator = "WEAPON_SEQ", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name="WEAPON_SEQ", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={
			@Parameter(name="sequence_name", value="WEAPON_SEQ"),
			@Parameter(name="initial_value",value="5"),
			@Parameter(name="increment_size",value="1")
	})
	@Column(name="weapon_ID")
	private int weaponId;
	
	@Column(name="weapon_name")
	private String name;
	
	@Column(name="damage")
	private String damage;
	
	@Column(name="damage_type")
	private String damageType;
	
	@Column(name="materials")
	private String materials;
}
