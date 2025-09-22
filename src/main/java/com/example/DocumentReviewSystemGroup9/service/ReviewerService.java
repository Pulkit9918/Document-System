package com.example.DocumentReviewSystemGroup9.service;

import com.example.DocumentReviewSystemGroup9.bean.Reviewer;

public interface ReviewerService {
	Reviewer loginReviewer(int reviewerID, String password);
	Reviewer registerReviewer(String password, String reviewerName);
}
