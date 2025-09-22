package com.example.DocumentReviewSystemGroup9.bean;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "audit")
public class AuditLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditID")
	private int auditID;
	@Column(name = "action")
	private String action;
	@Column(name = "userType")
	private String userType;
	@Column(name = "userID")
	private int userID;
	@Column(name = "timestamp")
	private LocalDateTime timestamp;
	public AuditLog() {}
	public AuditLog(String action, String userType, int userID) {
		super();
		this.action = action;
		this.userType = userType;
		this.userID = userID;
		this.timestamp = LocalDateTime.now();
	}
	public int getAuditID() { return auditID; }
	public void setAuditID(int auditID) { this.auditID = auditID; }
	public String getAction() { return action; }
	public void setAction(String action) { this.action = action; }
	public String getUserType() { return userType; }
	public void setUserType(String userType) { this.userType = userType; }
	public int getUserID() { return userID; }
	public void setUserID(int userID) { this.userID = userID; }
	public LocalDateTime getTimestamp() { return timestamp; }
	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
