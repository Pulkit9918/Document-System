package com.example.DocumentReviewSystemGroup9.controller;
 
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
 
import com.example.DocumentReviewSystemGroup9.service.*;
import com.example.DocumentReviewSystemGroup9.bean.Document;
import com.example.DocumentReviewSystemGroup9.dto.DocumentDTO;
import com.example.DocumentReviewSystemGroup9.repository.DocumentRepository;
 
@RestController
@RequestMapping("/documents")
@CrossOrigin("*")
public class DocumentController {
	@Autowired
	DocumentService documentService;
	@Autowired
	DocumentRepository documentRepository;
	@GetMapping("/all")
	public ResponseEntity<List<Document>> getDocuments() {
		return ResponseEntity.ok(documentService.getDocuments());
	}
//	@PostMapping("/addDocuments")
//	public ResponseEntity<Document> addDocument(@RequestBody Document document, @RequestHeader("adminID") Integer adminID) {
//		Document savedDocument = documentService.createDocument(document, adminID);
//		return ResponseEntity.ok(savedDocument);
//	}
	@PostMapping("/addDocuments")
	public ResponseEntity<Document> addDocument(@RequestBody Document document) {
		return ResponseEntity.ok(documentService.createDocument(document));
	}
//	@GetMapping("/reviewer/{reviewerID}")
//	public ResponseEntity<List<Document>> getByReviewer(@PathVariable Integer reviewerID) {
//	   return ResponseEntity.ok(documentService.getDocumentsByReviewer(reviewerID));
//	}
//	@GetMapping("/admin/{adminID}")
//	public ResponseEntity<List<Document>> getByAdmin(@PathVariable Integer adminID) {
//		return ResponseEntity.ok(documentService.getDocumentsByAdmin(adminID));
//	}
	@PutMapping("/{id}")
	public ResponseEntity<Document>updateDocument(@PathVariable Integer id, @RequestBody Document updatedDocument){
		Document updated = documentService.updateDocument(id, updatedDocument);
		return ResponseEntity.ok(updated);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Document> getDocumentById(@PathVariable Integer id){
		Document document = documentService.getDocumentById(id);
		return ResponseEntity.ok(document);
	}
	@DeleteMapping("/documents/{documentID}")
	public ResponseEntity<String> deleteDocument(@PathVariable int documentID) {
		documentService.deleteDocument(documentID);
	   return ResponseEntity.ok("Document deleted successfully!");
	}
	@GetMapping("/search")
	public ResponseEntity<List<DocumentDTO>> searchDocuments(@RequestParam String keywords){
		List<Document> results = documentService.searchDocumentsFlexible(keywords);
		List<DocumentDTO>documentDTOs = results.stream().map(DocumentDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok(documentDTOs);
	}
}