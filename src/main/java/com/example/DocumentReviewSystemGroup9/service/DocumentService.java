package com.example.DocumentReviewSystemGroup9.service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.example.DocumentReviewSystemGroup9.bean.Document;

public interface DocumentService {
// 
	 Document createDocument(Document document);
//	 List<Document> getDocumentsByReviewer(Integer reviewerID);
	 List<Document> getDocuments();
	 Document updateDocument(Integer id, Document updatedDocument);
	 Document getDocumentById(Integer id);
	 void deleteDocument(int documentID);
//	List<Document> getDocumentsByAdmin(Integer adminID);
//	 List<Document> searchDocuments(String keyword);
	 List<Document> searchDocumentsFlexible(String input);
}