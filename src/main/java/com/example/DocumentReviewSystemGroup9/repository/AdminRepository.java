package com.example.DocumentReviewSystemGroup9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DocumentReviewSystemGroup9.bean.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByAdminID(int adminID);
}
