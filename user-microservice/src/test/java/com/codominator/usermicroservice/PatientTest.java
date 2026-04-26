package com.codominator.usermicroservice;

import com.codominator.usermicroservice.repository.PatientRepository;
import com.codominator.usermicroservice.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientTest {
    @Autowired
    private PatientRepository repository;
    @Autowired
    private PatientService patientService;

    @Test
    public void createPatient() {
        patientService.createPatient();
    }

    @Test
    public void testFindById() {
       patientService.testFindAll();
    }



}
