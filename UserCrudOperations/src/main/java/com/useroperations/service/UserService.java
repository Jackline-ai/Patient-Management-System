package com.useroperations.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.useroperations.model.Department;
import com.useroperations.model.User;
import com.useroperations.repository.DepartmentRepository;
import com.useroperations.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Department saveUserToDepartment( Department department){
		if(department.getUsers() == null) {
			department.setUsers(new ArrayList<User> ());
		}
		
		for(User user : department.getUsers()) {
			user.setDepartment(department);
			
		}
		return departmentRepository.save(department);
	
	}
	
	public List <Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}
	
	public void deleteDepartmentById(Long id){
		departmentRepository.deleteById(id);
		}
	public Department addUsersToDepartment(Long departmentId, List<User> newUsers) {
		Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
		
		if(!departmentOptional.isPresent()){
			throw new RuntimeException("Department Not Found");
		}
			
	Department department = departmentOptional.get();
	
	for(User user: newUsers) {
		
		user.setDepartment(department);
	}
	
	userRepository.saveAll(newUsers);
	
	return departmentRepository.save(department);
}
	
}





