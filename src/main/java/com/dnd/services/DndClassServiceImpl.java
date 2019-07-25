package com.dnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dnd.beans.DndClass;
import com.dnd.dao.DndClassDao;

@Service("DndClassServiceImpl")
@Transactional
public class DndClassServiceImpl implements DndClassService {

	@Autowired
	private DndClassDao dndClassDao;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<DndClass> getAllDNDClasses() {
		
		return dndClassDao.findAll();
	}

	@Override
	public DndClass getClassByName(String className) {
		return dndClassDao.getByClassName(className);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public DndClass saveDndClass(DndClass dndClass) {
		return dndClassDao.save(dndClass);
	}

	@Override
	public DndClass getClassById(int id) {
		return dndClassDao.getOne(id);
	}

	@Override
	public void removeclassById(int classId) {
		dndClassDao.deleteById(classId);
	}
}
