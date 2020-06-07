package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientController {
    public List<Patient> getPatient();

    public Optional<Patient> getPatientById(Long id);

    public Patient addPatient(Patient patient);

    public String deletePatient(Long id);

    public String updatePatient(Patient patientUpdated);
}
