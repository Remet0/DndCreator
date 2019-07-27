package com.dnd.graphql;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnd.beans.Spell;
import com.dnd.mappings.SpellMapping;
import com.dnd.services.SpellService;

import graphql.schema.DataFetcher;

@Component
public class SpellDataFetchers {

	private SpellMapping sm = new SpellMapping();

	@Autowired
	private SpellService spellService;
	
	Logger logger = LoggerFactory.getLogger(DndClassDataFetchers.class);
	
	public DataFetcher<List<Spell>> getAllSpellsDataFetcher() {
		return dataFetchingEnvironment -> {
			return spellService.getAllSpells();
		};
	}
	
	public DataFetcher<Spell> getSpellByNameDataFetcher() {
		return dataFetchingEnvironment -> {
			String name = dataFetchingEnvironment.getArgument("spellName");
			return spellService.getSpellByName(name);
		};
	}

	public DataFetcher<Spell> getSpellByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			int id = dataFetchingEnvironment.getArgument("spellId");
			return spellService.getSpellById(id);
		};
	}

	public DataFetcher<Spell> createSpellDataFetcher() {
		return dataFetchingEnvironment -> {
			Map<String, Object> spell = dataFetchingEnvironment.getArgument("spell");
			Spell s = sm.SpellFromMap(spell);
			return spellService.addSpell(s);
		};
	}
	
	public DataFetcher<Integer> removeSpellDataFetcher() {
		return dataFetchingEnvironment -> {
			int id = dataFetchingEnvironment.getArgument("spellId");
			spellService.removeSpellById(id);
			return id;
		};
	}
}
