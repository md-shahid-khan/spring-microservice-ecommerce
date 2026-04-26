package com.codominator.usermicroservice.repository;

import com.codominator.usermicroservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
