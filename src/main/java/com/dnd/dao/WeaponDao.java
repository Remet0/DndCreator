package com.dnd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnd.beans.Weapon;

@Repository("weaponDao")
public interface WeaponDao extends JpaRepository<Weapon, Integer> {
	public List<Weapon> findAll();
	public List<Weapon> getByType(String type);
	public Weapon getByName(String name);
}
