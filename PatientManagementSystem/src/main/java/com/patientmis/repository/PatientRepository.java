package com.patientmis.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.patientmis.model.PatientRegistration;

public interface PatientRepository extends JpaRepository<PatientRegistration, Long> {
    @Query("SELECT p FROM PatientRegistration p WHERE " + "LOWER(p.firstName) LIKE LOWER(CONCAT('%', :name, '%')) "
	    + "OR LOWER(p.middleName) LIKE LOWER(CONCAT('%', :name, '%')) "
	    + "OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :name, '%')) "
	    + "OR LOWER(CONCAT(p.firstName, ' ', p.middleName, ' ', p.lastName)) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<PatientRegistration> searchByName(@Param("name") String name);

    @Query("SELECT COUNT(p) FROM PatientRegistration p")
    long countPatient();

    @Override
    Page<PatientRegistration> findAll(Pageable pageable);

}
