package com.example.DocumentReviewSystemGroup9.dto;

import java.time.LocalDateTime;
import com.example.DocumentReviewSystemGroup9.bean.Document;
import jakarta.persistence.Entity;

public class DocumentDTO {
	private Integer id;
	private LocalDateTime dateCreated;
	private LocalDateTime dateModified;
	private String title;

	public DocumentDTO(Document document) {
		this.id = document.getId();
		this.dateCreated = document.getDateCreated();
		this.dateModified = document.getDateModified();
		this.title = document.getTitle();
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public LocalDateTime getDateCreated() { return dateCreated; }
	public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
	public LocalDateTime getDateModified() { return dateModified; }
	public void setDateModified(LocalDateTime dateModified) { this.dateModified = dateModified; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
}