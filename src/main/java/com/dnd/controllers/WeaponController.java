package com.dnd.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.beans.Weapon;
import com.dnd.services.WeaponService;

@RestController
public class WeaponController {

	Logger logger = LoggerFactory.getLogger(WeaponController.class);
	
	@Autowired
	WeaponService weaponService;
	
	@RequestMapping(value = "/weapons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weapon> getAllWeapons() {
		return weaponService.getAllWeapons();
	}
	
	@RequestMapping(value = "weapon", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weapon createWeapon(@RequestBody Weapon weapon) {
		return weaponService.addWeapon(weapon);
	}
	
	@RequestMapping(value = "weapon", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weapon updateWeapon(@RequestBody Weapon weapon) {
		return weaponService.addWeapon(weapon);
	}
	
	@RequestMapping(value = "weapon/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weapon getWeaponById(@PathVariable int id) {
		return weaponService.getWeaponById(id);
	}
	
	@RequestMapping(value = "weapon/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weapon getWeaponByName(@PathVariable String name) {
		return weaponService.getWeaponByName(name);
	}
	
	@RequestMapping(value = "weapons/type/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weapon> getWeaponsByType(@PathVariable String type) {
		return weaponService.getWeaponsByType(type);
	}
}
