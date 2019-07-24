package com.dnd.graphql.dndclass;

import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.dnd.beans.DndClass;
import com.dnd.beans.Spell;
import com.dnd.mappings.DndClassMapping;
import com.dnd.mappings.SpellMapping;
import com.dnd.services.DndClassService;
import com.dnd.services.SpellService;

import graphql.schema.DataFetcher;

@Component
public class DndClassDataFetchers {
	
	@Autowired
	private DndClassMapping dcm;
	
	@Autowired
	private SpellMapping sm;
	
	@Autowired
	private DndClassService dndClassService;

	@Autowired
	private SpellService spellService;
	
	Logger logger = LoggerFactory.getLogger(DndClassDataFetchers.class);
	
	public DataFetcher<DndClass> getClassByNameDataFetcher() {
		return dataFetchingEnvironment -> {
			String name = dataFetchingEnvironment.getArgument("className");
			return dndClassService.getClassByName(name);
		};
	}

	public DataFetcher<DndClass> getClassByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			int id = dataFetchingEnvironment.getArgument("classId");
			return dndClassService.getClassById(id);
		};
	}

	public DataFetcher<DndClass> createClassDataFetcher() {
		return dataFetchingEnvironment -> {
			Map<String, Object> dndClass = dataFetchingEnvironment.getArgument("class");
			DndClass c = dcm.DndClassFromMap(dndClass);
			List<Map<String, Object>> listOfMappedSpells = (List<Map<String, Object>>)dndClass.get("spells");
			for(Map<String, Object> spell : listOfMappedSpells) {
				Spell s = sm.SpellFromMap(spell);
				Spell spellFromDB = spellService.getSpellById(s.getSpellId());
				c.getSpells().add(spellFromDB);
			}	
			return dndClassService.saveDndClass(c);
		};
	}
}