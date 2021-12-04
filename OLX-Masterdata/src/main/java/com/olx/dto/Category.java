package com.olx.dto;

import lombok.Data;

@Data
public class Category {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Category() {
		super();
	}

	public Category(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}

	private int id;
	private String categoryName;
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
