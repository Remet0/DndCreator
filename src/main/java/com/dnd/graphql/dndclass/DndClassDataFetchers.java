package com.dnd.graphql.dndclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.DndClass;
import com.dnd.beans.Spell;
import com.dnd.services.DndClassService;
import com.dnd.services.SpellService;

import graphql.schema.DataFetcher;

@Component
public class DndClassDataFetchers {

	@Autowired
	DndClassService dndClassService;

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
			String className = dataFetchingEnvironment.getArgument("className");
			DndClass c = new DndClass();
			c.setClassName(className);
			return dndClassService.saveDndClass(c);
		};
	}
}