package com.example.DocumentReviewSystemGroup9.bean;

import jakarta.persistence.*;
import lombok.*;

@Entity
@jakarta.persistence.Table(name = "reviewer")
public class Reviewer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reviewerID")
	private int reviewerID;
	@Column(name = "reviewerPassword")
	private String reviewerPassword;
	@Column(name = "reviewerName")
	private String reviewerName;
	
	public Reviewer() {}
	public Reviewer(int reviewerID, String reviewerPassword) {
		super();
		this.reviewerID = reviewerID;
		this.reviewerPassword = reviewerPassword;
	}
	public Reviewer(int reviewerID, String reviewerPassword, String reviewerName) {
		super();
		this.reviewerID = reviewerID;
		this.reviewerPassword = reviewerPassword;
		this.reviewerName = reviewerName;
	}

	public int getReviewerID() { return reviewerID; }
	public void setReviewerID(int reviewerID) { this.reviewerID = reviewerID; }
	public String getReviewerPassword() { return reviewerPassword; }
	public void setReviewerPassword(String reviewerPassword) { this.reviewerPassword = reviewerPassword; }
	public String getReviewerName() { return reviewerName; }
	public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }
}
