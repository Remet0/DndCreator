package com.dnd.services;

import java.util.List;

import com.dnd.beans.DndClass;

public interface DndClassService {

	public List<DndClass> getAllDNDClasses();
	public DndClass addDNDClass(DndClass pc);
	public DndClass getClassByName(String className);
	public DndClass saveDndClass(DndClass dndClass);
	public DndClass getClassById(int id);
}
