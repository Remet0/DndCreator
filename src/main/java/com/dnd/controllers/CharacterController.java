package com.dnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.DndClass;
import com.dnd.services.DndClassService;


@RestController
public class CharacterController {

	@Autowired
	DndClassService dndClassService;
	
	@RequestMapping(value = "classes", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public List<DndClass> getMethodName() {
		return dndClassService.getAllDNDClasses();
	}
	
	@RequestMapping(value = "class", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public DndClass getMethodName(@RequestBody DndClass pc) {
		System.out.println(pc.getClassId());
		System.out.println(pc.getClassName());
		return dndClassService.saveDndClass(pc);
	}
	
	@RequestMapping(value = "hello", method = RequestMethod.GET, produces = 
		{MediaType.APPLICATION_JSON_VALUE} )
	public String hello() {
		return "hello";
	}
}
