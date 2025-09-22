package com.example.DocumentReviewSystemGroup9.service;
import java.time.LocalDateTime;
import java.util.*;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DocumentReviewSystemGroup9.repository.AdminRepository;
import com.example.DocumentReviewSystemGroup9.repository.DocumentRepository;
import com.example.DocumentReviewSystemGroup9.repository.ReviewerRepository;
import com.example.DocumentReviewSystemGroup9.bean.Admin;
import com.example.DocumentReviewSystemGroup9.bean.Document;
import com.example.DocumentReviewSystemGroup9.bean.Reviewer;
 
@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private ReviewerRepository reviewerRepository;
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Document createDocument(Document document) {
		document.setDateCreated(LocalDateTime.now());
		document.setDateModified(LocalDateTime.now());
		return documentRepository.save(document);
	}
	@Override 
	public Document getDocumentById(Integer id) {
		return documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found with the id: " + id));
	}
	@Override 
	public Document updateDocument(Integer id, Document updatedDocument) {
		return documentRepository.findById(id).map(existingDoc -> {
			existingDoc.setTitle(updatedDocument.getTitle());
			existingDoc.setContent(updatedDocument.getContent());
			existingDoc.setContentSize(updatedDocument.getContent().length());
			existingDoc.setDateModified(LocalDateTime.now());
			return documentRepository.save(existingDoc);
		}).orElseThrow(() -> new RuntimeException("Document not found"));
	}
	
	@Override
	public List<Document> getDocuments() {
		return documentRepository.findAll();
	}
	@Override
	public void deleteDocument(int documentID) {
		documentRepository.deleteById(documentID);
	}
//	@Override
//	public List<Document> searchDocuments(String keywords){
//		String[] keywordArray = keywords.split("\\s+"); //splitting each searched up keywof by spaces
//		Set<Document> results = new HashSet<>();
//		for (String keyword : keywordArray) {
//			results.addAll(documentRepository.searchDocuments(keywords));
//			results.addAll(documentRepository.searchByFlexibleDate(keywords));
//		}
//		return new ArrayList<>(results);
//	}
	@Override
	public List<Document> searchDocumentsFlexible(String input) {
		if(input.matches("\\d{4}-\\{2}-\\d{2}")) {
			return documentRepository.searchByDateCreated(input);
		} else {
			return documentRepository.searchDocuments(input);
		}
	}
}
//	@Override
//	public List<Document> getDocumentsByReviewer(Integer reviewerID) {
//		return documentRepository.findByReviewer_ReviewerID(reviewerID);
//	}
//	@Override
//	public List<Document> getDocumentsByAdmin(Integer adminID) {
//		return documentRepository.findByAdmin_AdminID(adminID);
//	}