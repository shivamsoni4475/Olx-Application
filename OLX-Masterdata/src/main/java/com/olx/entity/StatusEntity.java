package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="adv_status")
public class StatusEntity {

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Id
	private int Id;
	
	@Column(name="status")
	private String status;

	@Override
	public String toString() {
		return "StatusEntity [Id=" + Id + ", status=" + status + "]";
	}

	public StatusEntity(int id, String status) {
		super();
		Id = id;
		this.status = status;
	}

	public StatusEntity() {
		super();
	}

	
	
	
}
