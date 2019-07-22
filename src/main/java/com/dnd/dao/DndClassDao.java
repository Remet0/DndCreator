package com.dnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.beans.DndClass;

@Repository("dndClassDao")
public interface DndClassDao extends JpaRepository<DndClass, Integer>{
	public List<DndClass> findAll();
	public DndClass getByClassName(String className);
}
