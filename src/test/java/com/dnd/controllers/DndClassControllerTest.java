package com.dnd.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dnd.beans.DndClass;
import com.dnd.services.DndClassService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(DndClassController.class)
public class DndClassControllerTest {

	@MockBean
	DndClassService dndClassService;
	
	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	Logger logger = LoggerFactory.getLogger(DndClassController.class);
	
	DndClass dndClass;
	
	@Before
	public void init() {
		dndClass = new DndClass(1, "name");
	}
	
	@Test
	public void getAllDndClasss() {
		List<DndClass> dndClass = new ArrayList<>();
		dndClass.add(new DndClass("name"));
		
		Mockito.when(dndClassService.getAllDNDClasses()).thenReturn(dndClass);
		
		try {
			mockMvc.perform(get("/classes")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].className").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void createDndClass() {
		Mockito.when(dndClassService.saveDndClass(Mockito.any(DndClass.class))).thenReturn(dndClass);
		
		try {
			mockMvc.perform(post("/class")
					.content(om.writeValueAsString(dndClass))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.className").value("name"))
					.andExpect(jsonPath("$.classId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void updateDndClass() {
		
		Mockito.when(dndClassService.saveDndClass(Mockito.any(DndClass.class))).thenReturn(dndClass);
		
		try {
			mockMvc.perform(put("/class")
					.content(om.writeValueAsString(dndClass))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.className").value("name"))
					.andExpect(jsonPath("$.classId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getDndClassById() {
		Mockito.when(dndClassService.getClassById(1)).thenReturn(dndClass);
		
		try {
			mockMvc.perform(get("/class/id/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.classId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getDndClassByName() {
		Mockito.when(dndClassService.getClassByName("name")).thenReturn(dndClass);
		
		try {
			mockMvc.perform(get("/class/name/name")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.classId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
