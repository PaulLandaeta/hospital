package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public List<Patient> findAllPatient();

    public Optional<Patient> findPatientById(Long id);

    public Patient savePatient(Patient patientNew);

    public String deletePatient(Long id);

    public String updatePatient(Patient patientNew);
}
