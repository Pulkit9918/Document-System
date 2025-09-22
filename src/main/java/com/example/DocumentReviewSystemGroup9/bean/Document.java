package com.example.DocumentReviewSystemGroup9.bean;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
@Entity
@Component
@jakarta.persistence.Table(name = "document")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "documentID")
	private Integer id;
	@Column(name = "dateCreated")
	private LocalDateTime dateCreated;
	@Column(name = "dateModified")
	private LocalDateTime dateModified;
//	@ManyToOne
//	@JoinColumn(name = "adminID", referencedColumnName = "adminID", nullable = false)
//	private Admin admin;
	@Column(name = "title")
	private String title;
	@Lob
	@Column(name="content")
	private String content;
	@Column(name="contentSize")
	private int contentSize;
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public LocalDateTime getDateCreated() { return dateCreated; }
	public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
	public LocalDateTime getDateModified() { return dateModified; }
	public void setDateModified(LocalDateTime dateModified) { this.dateModified = dateModified; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return content; } 
	public void setContent(String content) {this.content = content;}
	public int getContentSize() {return contentSize;}
	public void setContentSize(int contentSize) { this.contentSize = contentSize; }
//	public Admin getAdmin() { return admin; }
//	public void setAdmin(Admin admin) { this.admin = admin; }
}
//	@PrePersist
//	protected void onCreate() {
//		this.dateCreated = LocalDateTime.now();
//		this.dateModified = LocalDateTime.now();
//		this.contentSize = (content != null) ? content.length() : 0;
//	}
//	@PreUpdate
//	protected void onUpdate() {
//		this.dateModified = LocalDateTime.now();
//		this.contentSize = (content != null) ? content.length() : 0;
//	}
//	//   public void setReviewer(Reviewer reviewer) {
//	//	   this.reviewer = reviewer; 
//	//   }
//}