package com.useroperations.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserId;
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		addedAt = new Date();
		updatedAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "departmentId")
	private Department department;
	
	public Long getUserId() {
		return UserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getAddedAt() {
		return addedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}