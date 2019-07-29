package com.dnd.services;

import java.util.List;

import com.dnd.beans.Weapon;

public interface WeaponService {
	public List<Weapon> getAllWeapons();
	public Weapon getWeaponById(int id);
	public Weapon getWeaponByName(String weaponName);
	public List<Weapon> getWeaponsByType(String type);
	public Weapon addWeapon(Weapon weapon);
	public void removeWeaponById(int weaponId);
}
