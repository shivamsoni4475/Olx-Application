package com.olx.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "advertises")
public class AdvertiseEntity {

	    public AdvertiseEntity() {
		super();
	}

		public AdvertiseEntity(int id, String title, double price, String category, String description, String username,
			String status, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.username = username;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	    
	    @Column(name="title")
		private String title;
	    
	    @Column(name="price")
		private double price;
	    
	    @Column(name="category")
		private String category;
	    
	    @Column(name="description")
		private String description;
	    
	    @Column(name="username")
		private String username;
	    
	    @Column(name="status")
		private String status;

	    @Column(name="created_date")
	    private LocalDateTime createdDate = LocalDateTime.now();
	    
	    @Column(name="modified_date")
	    private LocalDateTime modifiedDate = LocalDateTime.now();

		@Override
		public String toString() {
			return "AdvertiseEntity [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category
					+ ", description=" + description + ", username=" + username + ", status=" + status
					+ ", createdDate=" + createdDate + "]";
		}

		public AdvertiseEntity(int id, String title, double price, String category, String description, String username,
				String status, LocalDateTime createdDate) {
			super();
			this.id = id;
			this.title = title;
			this.price = price;
			this.category = category;
			this.description = description;
			this.username = username;
			this.status = status;
			this.createdDate = createdDate;
		}

					
}
