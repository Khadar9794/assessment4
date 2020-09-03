package com.dxctraining.wisheditemmgt.wisheditem.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="wisheditems")
public class WishedItem {

	@Id
	private String id;
	
	private String name;
	
	private String productId;
	
	private Integer customerId;
	
	public WishedItem() {}
	
	public WishedItem(String name,String productId, Integer customerId) {
		this.name=name;
		this.productId=productId;
		this.customerId=customerId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishedItem other = (WishedItem) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
	
}
