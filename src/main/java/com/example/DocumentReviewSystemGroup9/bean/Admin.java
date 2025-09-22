package com.example.DocumentReviewSystemGroup9.bean;

import jakarta.persistence.*;
import lombok.*;

@Entity
@jakarta.persistence.Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminID")
	private int adminID;
	@Column(name = "adminPassword")
	private String adminPassword;
	
	public Admin() {}

	public Admin(int adminID, String adminPassword) {
		super();
		this.adminID = adminID;
		this.adminPassword = adminPassword;
	}

	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
