package com.example.DocumentReviewSystemGroup9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DocumentReviewSystemGroup9.bean.AuditLog;
import com.example.DocumentReviewSystemGroup9.repository.AuditLogRepository;

@Service
public class AuditLogServiceImpl implements AuditLogService {
	@Autowired
	private AuditLogRepository auditLogRepository;
	@Override
	public void logAction(String action, String userType, Integer userID) {
		AuditLog log = new AuditLog(action, userType, userID);
		auditLogRepository.save(log);
	}
}
