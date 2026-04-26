package com.codominator.usermicroservice.service;

import com.codominator.usermicroservice.entity.Patient;
import com.codominator.usermicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public Patient createPatient() {
        Patient patient = new Patient();
        patient.setUsername("test");
        patient.setEmail("test@gmail.com");
        patient.setGender("male");
        patient.setBirthDate(LocalDate.now());
        System.out.println("Patient created successfully");
        return repository.save(patient);

    }

    public List<Patient> testFindAll() {
        List<Patient> allPatient = repository.findAll();
        System.out.println(allPatient);
        return allPatient;

    }
}
