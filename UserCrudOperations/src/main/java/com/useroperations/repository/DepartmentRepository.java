package com.useroperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useroperations.model.Department;

public interface DepartmentRepository extends JpaRepository <Department, Long> {

}
