package com.patientmis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientmis.model.PatientRegistration;

public interface PatientRepository extends JpaRepository<PatientRegistration, Long> {

}
