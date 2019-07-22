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
@Table(name="RACE")
public class Race implements Serializable {
	
	private static final long serialVersionUID = 7871813732447949819L;

	@Id
	@GeneratedValue(generator = "RACE_SEQ", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name="RACE_SEQ", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={
			@Parameter(name="sequence_name", value="RACE_SEQ"),
			@Parameter(name="initial_value",value="5"),
			@Parameter(name="increment_size",value="1")
	})
	@Column(name="race_ID")
	private int raceId;
	
	@Column(name="race_name")
	private String raceName;
	
	@Column(name="str_bonus")
	private int strBonus;
	
	@Column(name="dex_bonus")
	private int dexBonus;
	
	@Column(name="con_bonus")
	private int conBonus;
	
	@Column(name="int_bonus")
	private int intBonus;
	
	@Column(name="wis_bonus")
	private int wisBonus;
	
	@Column(name="cha_bonus")
	private int chaBonus;

	public int getRaceId() {
		return raceId;
	}

	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public int getStrBonus() {
		return strBonus;
	}

	public void setStrBonus(int strBonus) {
		this.strBonus = strBonus;
	}

	public int getDexBonus() {
		return dexBonus;
	}

	public void setDexBonus(int dexBonus) {
		this.dexBonus = dexBonus;
	}

	public int getConBonus() {
		return conBonus;
	}

	public void setConBonus(int conBonus) {
		this.conBonus = conBonus;
	}

	public int getIntBonus() {
		return intBonus;
	}

	public void setIntBonus(int intBonus) {
		this.intBonus = intBonus;
	}

	public int getWisBonus() {
		return wisBonus;
	}

	public void setWisBonus(int wisBonus) {
		this.wisBonus = wisBonus;
	}

	public int getChaBonus() {
		return chaBonus;
	}

	public void setChaBonus(int chaBonus) {
		this.chaBonus = chaBonus;
	}

	public Race(int raceId, String raceName, int strBonus, int dexBonus, int conBonus, int intBonus, int wisBonus,
			int chaBonus) {
		super();
		this.raceId = raceId;
		this.raceName = raceName;
		this.strBonus = strBonus;
		this.dexBonus = dexBonus;
		this.conBonus = conBonus;
		this.intBonus = intBonus;
		this.wisBonus = wisBonus;
		this.chaBonus = chaBonus;
	}

	public Race() {
		super();
	}	
}
