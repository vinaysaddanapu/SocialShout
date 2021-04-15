package com.example.socialshout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="announcement")
public class Announcement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String title;
	private String subject;
	private String description;
	private String date;
	@Lob
	private byte[] image;


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id =  id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	
		
	
	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "Announcement [id=" + id + ", title=" + title + ", subject=" + subject + ", description=" + description
				+ ", date=" + date + "]";
	}
	
	
	
}
