package com.example.socialshout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String name;
	private String email_id;
	private String password;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email_id=" + email_id + ", password=" + password + "]";
	}
		
		
}
