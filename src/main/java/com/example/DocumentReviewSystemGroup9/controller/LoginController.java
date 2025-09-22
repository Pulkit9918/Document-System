package com.example.DocumentReviewSystemGroup9.controller;

import java.nio.charset.StandardCharsets;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.DocumentReviewSystemGroup9.*;
import com.example.DocumentReviewSystemGroup9.bean.*;
import com.example.DocumentReviewSystemGroup9.dto.ReviewerLoginRequest;
import com.example.DocumentReviewSystemGroup9.repository.*;
import com.example.DocumentReviewSystemGroup9.service.*;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LoginController {
	@Autowired
	ReviewerRepository reviewerRepo;
	@Autowired
	DocumentService documentService;
	@Autowired
	AuditLogService auditService;
   @PostMapping("/admin/login")
   public ResponseEntity<String> adminLogin(@RequestBody Map<String, String> payload) {
       String id = payload.get("id");
       String password = payload.get("password");
       if ("101".equals(id) && "adminpass".equals(password)) {
    	   auditService.logAction("Admin Login", "Admin", Integer.parseInt(id));
           return ResponseEntity.ok("Admin login successful");
       } else {
           return ResponseEntity.status(401).body("Invalid admin credentials");
       }
   }
   @PostMapping("/reviewer/login")
   public ResponseEntity<String> reviewerLogin(@RequestBody ReviewerLoginRequest loginRequest) {
      try {
          int reviewerID = loginRequest.getReviewerID();
          String password = loginRequest.getPassword();
          Optional<Reviewer> reviewer = reviewerRepo.findById(reviewerID);
          if (reviewer.isPresent()) {
              if (reviewer.get().getReviewerPassword().equals(password)) {
            	  auditService.logAction("Reviewer Login", "Reviewer", reviewerID);
                  return ResponseEntity.ok("Reviewer login successful");
              } else {
                  System.out.println("Password mismatch.");
              }
          } else {
              System.out.println("Reviewer ID not found.");
          }
          return ResponseEntity.status(401).body("Invalid reviewer credentials");
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(400).body("Invalid input");
      }
   }
   @GetMapping("/reviewers")
   public ResponseEntity<List<Reviewer>> getAllReviewers() {
	   List<Reviewer> reviewers = reviewerRepo.findAll();
	   return ResponseEntity.ok(reviewers);
   }
   @PostMapping("/reviewer/register")
   public ResponseEntity<Map<String, Object>> registerReviewer(@RequestBody Map<String, String> payload) {
      String password = payload.get("password");
      String reviewerName = payload.get("reviewerName");
      if (password == null || password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[!@#$%^&*()].*")) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(Map.of("message", "Password must be at least 8 characters and contain an uppercase letter and special character."));
      }
      Reviewer reviewer = new Reviewer();
      reviewer.setReviewerName(reviewerName);
      reviewer.setReviewerPassword(password);
      reviewer = reviewerRepo.save(reviewer);
      auditService.logAction("Reviewer Registered", "Reviewer", reviewer.getReviewerID());
      return ResponseEntity.ok(Map.of("id", reviewer.getReviewerID(), "message", "Registration successful"));
   }
   @PostMapping("/logout")
   public ResponseEntity<String> logout() {
       return ResponseEntity.ok("Logged out");
   }
   @GetMapping("/admin/report")
   public ResponseEntity<byte[]> generateReport() {
      List<Document> documents = documentService.getDocuments(); // Get all documents
      StringBuilder csv = new StringBuilder();
      csv.append(String.format("%-12s | %-30s | %-10s | %-20s | %-20s\n",
              "Document ID", "Title", "Size", "Date Created", "Date Modified"));
      csv.append("=".repeat(100)).append("\n"); // separator
      for (Document doc : documents) {
          csv.append(String.format("%-12d | %-30s | %-10d | %-20s | %-20s\n",
                  doc.getId(),
                  truncate(doc.getTitle(), 30),
                  doc.getContentSize(),
                  doc.getDateCreated().toString(),
                  doc.getDateModified().toString()
          ));
      }
      byte[] csvBytes = csv.toString().getBytes(StandardCharsets.UTF_8);
      HttpHeaders headers = new HttpHeaders();
      headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document-report.csv");
      headers.setContentType(MediaType.TEXT_PLAIN);
      return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
   }
   private String truncate(String text, int maxLength) {
      return text.length() > maxLength ? text.substring(0, maxLength - 3) + "..." : text;
   }
   @DeleteMapping("/reviewers/{id}")
   public ResponseEntity<String> deleteReviewer(@PathVariable int id) {
      if (reviewerRepo.existsById(id)) {
          reviewerRepo.deleteById(id);
          return ResponseEntity.ok("Reviewer deleted successfully");
      } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reviewer not found");
      }
   }
   @PutMapping("/reviewers/{id}")
   public ResponseEntity<String> updateReviewerName(@PathVariable int id, @RequestBody Map<String, String> payload) {
      String newName = payload.get("reviewerName");
      Reviewer reviewer = reviewerRepo.findById(id).orElse(null);
      if (reviewer != null) {
          reviewer.setReviewerName(newName);
          reviewerRepo.save(reviewer);
          return ResponseEntity.ok("Reviewer name updated");
      } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reviewer not found");
      }
   }
}