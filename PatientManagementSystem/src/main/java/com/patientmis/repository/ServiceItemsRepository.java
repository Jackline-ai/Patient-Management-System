package com.patientmis.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.patientmis.model.PatientServiceItems;

public interface ServiceItemsRepository extends JpaRepository<PatientServiceItems, Long> {

    @Query("SELECT s FROM PatientServiceItems s WHERE LOWER(s.serviceName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<PatientServiceItems> searchServiceByName(@Param("name") String name);

    @Query("SELECT COUNT(s) FROM PatientServiceItems s")
    long countService();

    @Override
    Page<PatientServiceItems> findAll(Pageable pageable);
}
