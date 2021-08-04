package com.phoenix.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

public class Product1 implements Persistable<Integer>{
	@Id
	private int id;
	private String name;
	private float price;
	
	@Transient
	private boolean isInsert;
	public Product1()
	{
		
	}

	

	
	public Product1(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [Id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	//PersistableMethod fetched
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		
		return id;
	}
	//PersistableMethod fetched
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isInsert;
	}
	
	public void setInsert(boolean isInsert)
	{
		this.isInsert=isInsert;
	}
	
	

}
