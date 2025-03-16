package com.useroperations.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.useroperations.model.Department;
import com.useroperations.model.User;
import com.useroperations.repository.DepartmentRepository;
import com.useroperations.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired 
	private UserService service;
	
	@PostMapping("/department/{departmentId}")
	public ResponseEntity<Department> saveUserToDepartment(@RequestBody Department department){
		for(User user : department.getUsers()) {
			user.setDepartment(department);

		}
		Department savedDepartment = service.saveUserToDepartment(department);
		return ResponseEntity.ok(savedDepartment);
	
	}
	@GetMapping
	public List<Department> getAllDepartments(){
		return service.getAllDepartments();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Department> getDepartmentById(@PathVariable Long id) {
		return service.getDepartmentById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartmentById(@PathVariable Long id) {
		try {
			service.deleteDepartmentById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/department/{departmentId}")
	public ResponseEntity<Department> updateDepartmentWithUsers(
	        @PathVariable Long departmentId,
	        @RequestBody List<User> newUsers) {

	    // Fetch the existing department
	    Optional<Department> departmentOptional = service.getDepartmentById(departmentId);

	    if (!departmentOptional.isPresent()) {
	        return ResponseEntity.notFound().build(); // Return 404 if department not found
	    }

	    Department department = departmentOptional.get();

	 
	    if (department.getUsers() == null) {
	        department.setUsers(new ArrayList<>()); 
	    }

	
	    for (User user : newUsers) {
	        user.setDepartment(department); 
	        department.getUsers().add(user);
	    }

	   
	    Department savedDepartment = service.saveUserToDepartment(department);
	    
	    return ResponseEntity.ok(savedDepartment);
	}
	@PostMapping 
	public ResponseEntity<Department>add
}

