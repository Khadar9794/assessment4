package com.dxctraining.wisheditemmgt.wisheditem.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.wisheditemmgt.exception.InvalidArgumentException;
import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;
import com.dxctraining.wisheditemmgt.wisheditem.service.IWishedItemService;
import com.dxctraining.wisheditemmgt.wisheditem.service.WishedItemServiceImpl;


@DataJpaTest
@Import({ WishedItemServiceImpl.class })
@ExtendWith(SpringExtension.class)
public class WishedItemSericeImplTest {

	@Autowired
	private IWishedItemService service;

	@Autowired
	private EntityManager entitymanager;

	@Test
	public void testAdd_1() {
		Executable executable = () -> service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable);
	}

	@Test
	public void testAdd_2() {
		String name = "watch";
		WishedItem wished = new WishedItem();
		wished.setName(name);
		wished = service.save(wished);
		
		TypedQuery<WishedItem> query = entitymanager.createQuery("from WishedList", WishedItem.class);
		List<WishedItem> list = query.getResultList();
		WishedItem stored = list.get(0);
		Assertions.assertEquals(wished.getId(), stored.getId());
		Assertions.assertEquals(name, stored.getName());
	}


}
