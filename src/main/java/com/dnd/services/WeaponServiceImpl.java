package com.dnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dnd.beans.Weapon;
import com.dnd.dao.WeaponDao;

@Repository("WeaponServiceImpl")
@Transactional
public class WeaponServiceImpl implements WeaponService {

	@Autowired
	private WeaponDao weaponDao;

	@Override
	public List<Weapon> getAllWeapons() {
		return weaponDao.findAll();
	}

	@Override
	public Weapon getWeaponById(int id) {
		return weaponDao.getOne(id);
	}

	@Override
	public Weapon getWeaponByName(String weaponName) {
		return weaponDao.getByName(weaponName);
	}

	@Override
	public Weapon addWeapon(Weapon weapon) {

		return weaponDao.save(weapon);
	}

	@Override
	public void removeWeaponById(int weaponId) {
		weaponDao.delete(weaponDao.getOne(weaponId));
	}

	@Override
	public List<Weapon> getWeaponsByType(String type) {
		return weaponDao.getByType(type);
	}
}
