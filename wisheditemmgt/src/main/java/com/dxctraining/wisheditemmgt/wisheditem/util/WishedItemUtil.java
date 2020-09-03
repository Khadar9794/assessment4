package com.dxctraining.wisheditemmgt.wisheditem.util;

import org.springframework.stereotype.Component;

import com.dxctraining.wisheditemmgt.wisheditem.dto.WishedItemDto;
import com.dxctraining.wisheditemmgt.wisheditem.entities.WishedItem;


@Component
public class WishedItemUtil {

	public WishedItemDto wishedItemDto(WishedItem wishedItem, String productId, String productName, Integer customerId, String customerName) {
		WishedItemDto dto = new WishedItemDto(wishedItem.getId(), wishedItem.getName());
		dto.setProductId(productId);
		dto.setProductName(productName);
		dto.setCustomerId(customerId);
		dto.setCustomerName(customerName);
		return dto;
	}
}
