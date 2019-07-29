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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="WEAPON")
public class Weapon implements Serializable{
	
	private static final long serialVersionUID = -1324316665625859485L;

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
	
	@Column(name="weapon_type")
	private String type;
	
	@Column(name="weapon_range")
	private int range;
	
	@Column(name="damage")
	private String damage;
	
	@Column(name="damage_type")
	private String damageType;
	
	@Column(name="materials_required")
	private String materials_required;
	
	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public String getMaterials_required() {
		return materials_required;
	}

	public void setMaterials_required(String materials_required) {
		this.materials_required = materials_required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public Weapon(int weaponId, String name, String type, int range, String damage, String damageType,
			String materials_required) {
		super();
		this.weaponId = weaponId;
		this.name = name;
		this.type = type;
		this.range = range;
		this.damage = damage;
		this.damageType = damageType;
		this.materials_required = materials_required;
	}

	@Override
	public String toString() {
		return "Weapon [weaponId=" + weaponId + ", name=" + name + ", type=" + type + ", range=" + range + ", damage="
				+ damage + ", damageType=" + damageType + ", materials_required=" + materials_required + "]";
	}

	public Weapon() {
	}
}
