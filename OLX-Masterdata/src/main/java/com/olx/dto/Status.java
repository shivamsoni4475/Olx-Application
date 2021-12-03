package com.olx.dto;

import lombok.Data;

@Data
public class Status {
	public Status() {
		super();
	}
	public Status(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private int id;
	private String status;
	
}
