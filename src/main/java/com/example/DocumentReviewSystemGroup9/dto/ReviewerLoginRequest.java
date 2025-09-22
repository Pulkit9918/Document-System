package com.example.DocumentReviewSystemGroup9.dto;

public class ReviewerLoginRequest {
	private int reviewerID;
	private String password;
	private String reviewerName;
	public ReviewerLoginRequest() {}
	public ReviewerLoginRequest(int reviewerID, String password) {
		this.reviewerID = reviewerID;
		this.password = password;
	}
	public ReviewerLoginRequest(int reviewerID, String password, String reviewerName) {
		this.reviewerID = reviewerID;
		this.password = password;
		this.reviewerName = reviewerName;
	}
	public int getReviewerID() { return reviewerID; }
	public void setReviewerID(int reviewerID) { this.reviewerID = reviewerID; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getName() { return reviewerName; }
	public void setName(String name) { this.reviewerName = reviewerName; }
}
