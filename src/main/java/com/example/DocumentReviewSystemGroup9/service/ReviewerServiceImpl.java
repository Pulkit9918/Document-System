package com.example.DocumentReviewSystemGroup9.service;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DocumentReviewSystemGroup9.bean.Reviewer;
import com.example.DocumentReviewSystemGroup9.repository.ReviewerRepository;

@Service
public class ReviewerServiceImpl implements ReviewerService {
	@Autowired
	ReviewerRepository reviewerRepository;
	private static final Random random = new Random();

	@Override
	public Reviewer loginReviewer(int reviewerID, String password) {
		Reviewer reviewer = reviewerRepository.findByReviewerID(reviewerID);
		if (reviewer != null && reviewer.getReviewerPassword().equals(password)) {
			return reviewer;
		}
		return null;
	}
	@Override
	public Reviewer registerReviewer(String password, String reviewerName) {
		int reviewerID = generateUniqueReviewerID();
		Reviewer newReviewer = new Reviewer(reviewerID, password, reviewerName);
		return reviewerRepository.save(newReviewer);
	}
	private int generateUniqueReviewerID() {
		int id;
		do {
			id = 100 + random.nextInt(900);
		} while (reviewerRepository.findByReviewerID(id) != null);
		return id;
	}
}