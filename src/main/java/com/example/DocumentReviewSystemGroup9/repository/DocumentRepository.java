package com.example.DocumentReviewSystemGroup9.repository;
import org.springframework.*;
import java.util.*;
import com.example.DocumentReviewSystemGroup9.bean.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
//	List<Document> findByAdmin_AdminID(Integer adminID);
//	List<Document> findByReviewer_ReviewerID(Integer reviewerID);
	Document findDocumentById(int id);
	void deleteById(int documentId);
//	@Query(value = "SELECT d.* FROM Document d WHERE LOWER(CAST(d.content AS TEXT)) LIKE %:keyword%", nativeQuery = true)
//    List<Document> searchDocuments(@Param("keyword") String keyword);
	@Query("SELECT d FROM Document d WHERE " +
		      "LOWER(d.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		      "LOWER(CAST(d.content AS string)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		      "CAST(d.id AS string) LIKE CONCAT('%', :keyword, '%')")
		List<Document> searchDocuments(@Param("keyword") String keyword);
	@Query(value = "Select d.* FROM Document d WHERE CAST(d.dateCreated AS string) LIKE %:date%", nativeQuery = true)
	List<Document> searchByDateCreated(@Param("date") String date);
}