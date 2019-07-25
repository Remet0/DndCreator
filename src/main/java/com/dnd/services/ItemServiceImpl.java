package com.dnd.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.beans.Item;
import com.dnd.dao.ItemDao;

@Service("ItemSerivceImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	@Override
	public List<Item> getAllItems() {
		return itemDao.findAll();
	}

	@Override
	public Item getItemById(int id) {
		return itemDao.getOne(id);
	}

	@Override
	public Item getItemByName(String name) {
		return itemDao.getByName(name);
	}

	@Override
	public Item getItemByType(String type) {
		return itemDao.getByType(type);
	}

	@Override
	public void removeItemByid(int id) {
		itemDao.deleteById(id);
	}

	@Override
	public Item addItem(Item item) {
		return itemDao.save(item);
	}

}
