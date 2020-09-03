package com.dxctraining.wisheditemmgt.wisheditem.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.wisheditemmgt.exception.InvalidArgumentException;
import com.dxctraining.wisheditemmgt.exception.WishedItemNotFoundException;
import com.dxctraining.wisheditemmgt.wisheditem.dao.IWisheditemDao;
import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;

@Service
public class WishedItemServiceImpl implements IWishedItemService {

	@Autowired
	private IWisheditemDao dao;


	@Override
	public WishedItem findById(String id) {
		Optional<WishedItem> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new WishedItemNotFoundException("wishlist is null");
		}
		WishedItem wishedItem = optional.get();
		return wishedItem;
	}


	@Override
	public List<WishedItem> findByName(String name) {
		List<WishedItem> list = dao.findByName(name);
		return list;
	}

	@Override
	public WishedItem save(WishedItem wishedItem) {
		validate(wishedItem);
		wishedItem = dao.save(wishedItem);
		return wishedItem;
	}

	@Override
	public List<WishedItem> findAll() {
		List<WishedItem> list = dao.findAll();
		return list;
	}
	@Override
	public List<WishedItem> allWishedItemsFromProducts(String productId, Integer customerId) {
		List<WishedItem> list = dao.allWishedItemFromProducts(productId, customerId);
		return list;
	}

	public void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}
}
