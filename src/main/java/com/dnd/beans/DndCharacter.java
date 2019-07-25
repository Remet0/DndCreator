package com.dnd.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CHARACTER")
public class DndCharacter implements Serializable {

	private static final long serialVersionUID = -4372613136462121569L;

	@Id
	@GeneratedValue(generator = "CHARACTER_SEQ", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name="RACE_SEQ", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={
			@Parameter(name="sequence_name", value="RACE_SEQ"),
			@Parameter(name="initial_value",value="5"),
			@Parameter(name="increment_size",value="1")
	})
	@Column(name="character_id")
	private int characterId;
	
	@Column(name="character_name")
	private String name;
	
	@Column(name="strength")
	private int strength;
	
	@Column(name="dexterity")
	private int dexterity;
	
	@Column(name="consitution")
	private int constitution;
	
	@Column(name="itelligence")
	private int intelligence;
	
	@Column(name="wisdom")
	private int wisdom;
	
	@Column(name="charisma")
	private int charisma;
	
	@Column(name="alignment")
	private Alignment alignment;
	
	@Column(name="subAlignment")
	private SubAlignment subAlignment;
	
	@Column(name="race")
	private Race race;
	
	@Column(name="title")
	private String title;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="deity")
	private String deity;
	
	@Column(name="dnd_class")
	private DndClass dndClass;
	
	@Column(name="hitpoints")
	private int hitpoints;
	
	@Column(name="armor_class")
	private int armorClass;
	
	@Column(name="size")
	private String size;
	
	@Column(name="appearence")
	private String appearence;
	
	@Column(name="location")
	private String location;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "CHARACTER_CHARACTER", joinColumns = @JoinColumn(name="Character_ID"), inverseJoinColumns = @JoinColumn(name="Second_Character_ID"))
	private Set<DndCharacter> followers = new HashSet<>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "CHARACTER_WEAPON", joinColumns = @JoinColumn(name="Character_ID"), inverseJoinColumns = @JoinColumn(name="Weapon_ID"))
	private Set<Weapon> weapons = new HashSet<>();

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "CHARACTER_ITEM", joinColumns = @JoinColumn(name="Character_ID"), inverseJoinColumns = @JoinColumn(name="Item_ID"))
	private List<Weapon> items = new ArrayList<>();
	
	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public SubAlignment getSubAlignment() {
		return subAlignment;
	}

	public void setSubAlignment(SubAlignment subAlignment) {
		this.subAlignment = subAlignment;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDeity() {
		return deity;
	}

	public void setDeity(String deity) {
		this.deity = deity;
	}

	public DndClass getDndClass() {
		return dndClass;
	}

	public void setDndClass(DndClass dndClass) {
		this.dndClass = dndClass;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAppearence() {
		return appearence;
	}

	public void setAppearence(String appearence) {
		this.appearence = appearence;
	}

	public Set<DndCharacter> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<DndCharacter> followers) {
		this.followers = followers;
	}

	public Set<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(Set<Weapon> weapons) {
		this.weapons = weapons;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public DndCharacter() {
		super();
	}
	


	public void updateStats() {
		
		strength += race.getStrBonus();
		dexterity += race.getDexBonus();
		constitution += race.getConBonus();
		intelligence += race.getIntBonus();
		wisdom += race.getWisBonus();
		charisma += race.getChaBonus();
	}
}
