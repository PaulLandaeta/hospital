package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Hospital;
import com.digitalharbor.hospital.model.Patient;
import com.digitalharbor.hospital.model.Speciality;
import com.digitalharbor.hospital.repository.HospitalRepository;
import com.digitalharbor.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Patient> findAllPatient(Long id) {
        List<Patient> patients = patientRepository.findAll();
        List<Patient> byHospital = new LinkedList<>();
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        patients.forEach(patient -> {
            if(patient.getHospital().getId() == hospital.getId()) {
                byHospital.add(patient);
            }
        });
        return byHospital;
    }

    @Override
    public Optional<Patient> findPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient;
    }

    @Override
    public Patient savePatient(Patient patientNew) {
        Hospital hospital = hospitalRepository.findById(patientNew.getHospital().getId()).orElse(null);
        if(patientNew != null) {
            patientNew.setHospital(hospital);
            return patientRepository.save(patientNew);
        }
        return new Patient();
    }

    @Override
    public String deletePatient(Long id) {
        if(patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
            return "Patient has been deleted";
        }
        return "Error! The patient does not exist";
    }

    @Override
    public String updatePatient(Patient patientNew) {
        Long num = patientNew.getId();
        if(patientRepository.findById(num).isPresent()) {
            Patient patientToUpdate = new Patient();
            patientToUpdate.setId(patientNew.getId());
            patientToUpdate.setName(patientNew.getName());
            patientRepository.save(patientToUpdate);
            return "Patient has been updated";
        }
        return "Error! Cannot update the patient";
    }
}
