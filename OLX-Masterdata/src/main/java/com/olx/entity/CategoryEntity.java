package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity {

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Id
	private int Id;
	
	@Column(name="name")
	private String category;
	
	@Column(name="description")
	private String desc;

	@Override
	public String toString() {
		return "CategoryEntity [Id=" + Id + ", category=" + category + ", desc=" + desc + "]";
	}

	public CategoryEntity(int id, String category, String desc) {
		super();
		Id = id;
		this.category = category;
		this.desc = desc;
	}

	public CategoryEntity() {
		super();
	}

	
	
}
