package com.example.DocumentReviewSystemGroup9.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DocumentReviewSystemGroup9.bean.Reviewer;

public interface ReviewerRepository extends JpaRepository<Reviewer, Integer>{
	Reviewer findByReviewerID(int reviewerID);
}
