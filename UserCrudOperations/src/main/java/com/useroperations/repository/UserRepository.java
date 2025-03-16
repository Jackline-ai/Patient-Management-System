package com.useroperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useroperations.model.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
