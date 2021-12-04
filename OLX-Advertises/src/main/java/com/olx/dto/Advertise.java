package com.olx.dto;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class Advertise {
		public Advertise() {
		super();
	}
		public Advertise(int id, String title, double price, String category, String description, String username,
			LocalDateTime createdDate, LocalDateTime modifiedDate, String status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
		@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category
				+ ", description=" + description + ", username=" + username + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		private int id;
		private String title;
		private double price;
		private String category;
		private String description;
		private String username;
		@CreationTimestamp
		private LocalDateTime createdDate;
		@CreationTimestamp
		private LocalDateTime modifiedDate;
		private String status;		
}
