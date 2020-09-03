package com.dxctraining.wisheditemmgt.wisheditem.service;

import java.util.List;

import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;

public interface IWishedItemService {


	WishedItem findById(String id);
	
	List<WishedItem> findByName(String name);
	WishedItem save(WishedItem wishedItem);

	List<WishedItem> findAll();

	List<WishedItem> allWishedItemsFromProducts(String productId, Integer customerId);

}
