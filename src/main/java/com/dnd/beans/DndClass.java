package com.dnd.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="DNDCLASS")
public class DndClass implements Serializable{
	
	private static final long serialVersionUID = 5695616463281671305L;

	@Id
	@GeneratedValue(generator = "DNDCLASS_SEQ", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name="DNDCLASS_SEQ", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={
			@Parameter(name="sequence_name", value="DNDCLASS_SEQ"),
			@Parameter(name="initial_value",value="5"),
			@Parameter(name="increment_size",value="1")
	})
	@Column(name="class_ID")
	private int classId;
	
	@Column(name="class_name")
	private String className;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "DNDCLASS_SPELLS", joinColumns = @JoinColumn(name="class_ID"), inverseJoinColumns = @JoinColumn(name="spell_ID"))
	private Set<Spell> spells = new HashSet<Spell>();
	
	public DndClass() {
		super();
	}
	
	public DndClass(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	
	public DndClass(String className) {
		super();
		this.className = className;
	}
	
	
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<Spell> getSpells() {
		return spells;
	}

	public void setSpells(Set<Spell> spells) {
		this.spells = spells;
	}
	
	@Override
	public String toString() {
		return "DndClass [classId=" + classId + ", className=" + className + ", spells=" + spells + "]";
	}
}
