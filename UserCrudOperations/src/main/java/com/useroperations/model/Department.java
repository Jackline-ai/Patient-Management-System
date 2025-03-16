package com.useroperations.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	private String departmentName;
	private String description;
	
	@OneToMany(mappedBy ="department", cascade= {CascadeType.ALL}, orphanRemoval = true)
	
	@JsonIgnore
	private List<User> users = new ArrayList<>();
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDescription() {
		return description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
