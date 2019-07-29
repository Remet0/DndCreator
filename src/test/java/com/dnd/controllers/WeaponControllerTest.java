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

import com.dnd.beans.Weapon;
import com.dnd.services.WeaponService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(WeaponController.class)
public class WeaponControllerTest {

	@MockBean
	WeaponService weaponService;
	
	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	Weapon weapon;
	
	Logger logger = LoggerFactory.getLogger(WeaponControllerTest.class);
	
	@Before
	public void init() {
		weapon = new Weapon(1, "name", "type", 60, "1d8", "piercing", "arrows");
	}
	
	@Test
	public void getAllWeapons() {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(weapon);
		
		Mockito.when(weaponService.getAllWeapons()).thenReturn(weapons);
		
		try {
			mockMvc.perform(get("/weapons")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].name").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void createWeapon() {
		Mockito.when(weaponService.addWeapon(Mockito.any(Weapon.class))).thenReturn(weapon);
		
		try {
			mockMvc.perform(post("/weapon")
					.content(om.writeValueAsString(weapon))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("name"))
					.andExpect(jsonPath("$.weaponId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test
	public void updateWeapon() {
		Mockito.when(weaponService.addWeapon(Mockito.any(Weapon.class))).thenReturn(weapon);
		
		try {
			mockMvc.perform(put("/weapon")
					.content(om.writeValueAsString(weapon))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("name"))
					.andExpect(jsonPath("$.weaponId").value("1"))
					.andExpect(jsonPath("$.type").value("type"))
					.andExpect(jsonPath("$.range").value("60"))
					.andExpect(jsonPath("$.damage").value("1d8"))
					.andExpect(jsonPath("$.damageType").value("piercing"))
					.andExpect(jsonPath("$.materials_required").value("arrows"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getWeaponById() {
		Mockito.when(weaponService.getWeaponById(1)).thenReturn(weapon);
		
		try {
			mockMvc.perform(get("/weapon/id/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.weaponId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getWeaponByName() {
		Mockito.when(weaponService.getWeaponByName("name")).thenReturn(weapon);
		
		try {
			mockMvc.perform(get("/weapon/name/name")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.weaponId").value("1"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void getWeaponsBytype() {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(weapon);
		
		Mockito.when(weaponService.getWeaponsByType("type")).thenReturn(weapons);
		
		try {
			mockMvc.perform(get("/weapons/type/type")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$[0].name").value("name"));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
