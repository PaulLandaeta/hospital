package com.digitalharbor.hospital.repository;

import com.digitalharbor.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Void save(Optional<Patient> patientToUpdate);
}
