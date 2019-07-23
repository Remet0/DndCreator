package com.dnd.graphql.dndclass;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.DndClass;
import com.dnd.mappings.DndClassMapping;
import com.dnd.services.DndClassService;
import com.dnd.services.SpellService;

import graphql.schema.DataFetcher;

@Component
public class DndClassDataFetchers {
	
	@Autowired
	private DndClassMapping dcm;
	
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
			logger.error(spellService.toString());
			Map<String, Object> dndClass = dataFetchingEnvironment.getArgument("class");
			DndClass c = dcm.DndClassFromMap(dndClass);
			return dndClassService.saveDndClass(c);
		};
	}
}