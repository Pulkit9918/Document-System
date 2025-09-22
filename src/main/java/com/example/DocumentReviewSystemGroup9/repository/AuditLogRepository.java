package com.example.DocumentReviewSystemGroup9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DocumentReviewSystemGroup9.bean.*;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {

}
