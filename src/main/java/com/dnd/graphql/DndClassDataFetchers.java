package com.dnd.graphql;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.DndClass;
import com.dnd.beans.Spell;
import com.dnd.mappings.DndClassMapping;
import com.dnd.mappings.SpellMapping;
import com.dnd.services.DndClassService;

import graphql.schema.DataFetcher;

@Component
public class DndClassDataFetchers {
	
	private DndClassMapping dcm = new DndClassMapping();
	
	private SpellMapping sm = new SpellMapping();
	
	@Autowired
	private DndClassService dndClassService;

	
	Logger logger = LoggerFactory.getLogger(DndClassDataFetchers.class);
	
	
	public DataFetcher<List<DndClass>> getAllDndClassesDataFetcher() {
		return dataFetchingEnvironment -> {
			return dndClassService.getAllDNDClasses();
		};
	}
	
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
				c.getSpells().add(s);
			}	

			return dndClassService.saveDndClass(c);
		};
	}
	
	public DataFetcher<Integer> removeClassDataFetcher() {
		return dataFetchingEnvironment -> {
			int id = dataFetchingEnvironment.getArgument("classId");
			dndClassService.removeclassById(id);
			return id;
		};
	}
}