package com.dnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.DndClass;
import com.dnd.services.DndClassService;


@RestController
public class DndClassController {

	@Autowired
	DndClassService dndClassService;
	
	@RequestMapping(value = "classes", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public List<DndClass> getAllClasses() {
		return dndClassService.getAllDNDClasses();
	}
	
	@RequestMapping(value = "class", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public DndClass createClass(@RequestBody DndClass pc) {
		return dndClassService.saveDndClass(pc);
	}
	
	@RequestMapping(value = "class", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public DndClass updateClass(@RequestBody DndClass pc) {
		return dndClassService.saveDndClass(pc);
	}
	
	@RequestMapping(value = "class/id/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public DndClass getSpellById(@PathVariable int id) {
		DndClass dndClass = dndClassService.getClassById(id);
		return dndClass;
	}
	
	@RequestMapping(value = "class/name/{name}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public DndClass getSpellByName(@PathVariable String name) {
		DndClass dndClass = dndClassService.getClassByName(name);
		return dndClass;
	}
}
