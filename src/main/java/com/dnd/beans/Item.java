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
@Table(name="ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = -2714372594954333844L;

	@Id
	@GeneratedValue(generator = "ITEM_SEQ", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name="ITEM_SEQ", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator", parameters={
			@Parameter(name="sequence_name", value="ITEM_SEQ"),
			@Parameter(name="initial_value",value="5"),
			@Parameter(name="increment_size",value="1")
	})
	@Column(name="item_Id")
	private int itemId;
	
	@Column(name="item_Name")
	private String itemName;
	
	@Column(name="item_type")
	private String type;
	
	@Column(name="description")
	private String description;

	public Item(int itemId, String name, String type, String description) {
		super();
		this.itemId = itemId;
		this.itemName = name;
		this.type = type;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + itemName + ", type=" + type + ", description=" + description + "]";
	}

	public Item() {
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		this.itemName = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
