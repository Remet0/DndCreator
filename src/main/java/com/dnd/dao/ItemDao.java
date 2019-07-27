package com.dnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.beans.Item;

@Repository("itemDao")
public interface ItemDao extends JpaRepository<Item, Integer> {
	public List<Item> findAll();
	public List<Item> getByType(String type);
	public Item getByItemName(String name);
}
