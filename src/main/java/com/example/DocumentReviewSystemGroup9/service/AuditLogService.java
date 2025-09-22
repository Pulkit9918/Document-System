package com.example.DocumentReviewSystemGroup9.service;

public interface AuditLogService {
	void logAction(String action, String userType, Integer userID);
}
