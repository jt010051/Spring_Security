package com.jt.springsecurityproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column(name="Email")
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	
		
		public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
		public String getUserName() {
		 return username;
		 }
		 public void setUserName(String userName) {
		 this.username = userName;
		 }
		 public String getPassword() {
		 return password;
		 }
		 public void setPassword(String password) {
		 this.password = password;
		 }
		 public void setFullName(String fullName) {
		 this.name = fullName;
		 }
		 public String getFullName() {
		 return name;
		 }
		 public void setEmail(String email) {
		 this.email = email;
		 }
		 public String getEmail() {
		 return email;
		 }
		public User(int id, String name, String email, String username, String password, String role) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.username = username;
			this.password = password;
			this.role = role;
		}
		 
}
