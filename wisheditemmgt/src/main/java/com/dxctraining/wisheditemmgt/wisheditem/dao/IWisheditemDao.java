package com.dxctraining.wisheditemmgt.wisheditem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;


public interface IWisheditemDao extends JpaRepository<WishedItem, String>{
	
	List<WishedItem> findByName(String name);
	
	@Query("from wishedList where productId=:productId and customerId=:customerId")
	List<WishedItem> allWishedItemFromProducts(@Param("productId") String productId, @Param("customerId")Integer customerId);
}
