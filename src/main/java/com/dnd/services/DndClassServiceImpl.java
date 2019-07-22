package com.dnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dnd.beans.DndClass;
import com.dnd.dao.DndClassDao;

@Service("PlayableClassServiceImpl")
@Transactional
public class DndClassServiceImpl implements DndClassService {

	@Autowired
	DndClassDao dndClassDao;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<DndClass> getAllDNDClasses() {
		
		return dndClassDao.findAll();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public DndClass addDNDClass(DndClass pc)	{
		return dndClassDao.save(pc);
	}

	@Override
	public DndClass getClassByName(String className) {
		return dndClassDao.getByClassName(className);
	}
	
	@Override
	public DndClass saveDndClass(DndClass dndClass) {
		return dndClassDao.save(dndClass);
	}

	@Override
	public DndClass getClassById(int id) {
		return dndClassDao.getOne(id);
	}
}
