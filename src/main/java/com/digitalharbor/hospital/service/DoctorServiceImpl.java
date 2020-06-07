package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Doctor;
import com.digitalharbor.hospital.model.Hospital;
import com.digitalharbor.hospital.model.Speciality;
import com.digitalharbor.hospital.repository.DoctorRepository;
import com.digitalharbor.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Doctor> findAllDoctors(Long id) {
        List<Doctor> doctors = doctorRepository.findAll();
        List<Doctor> byHospital = new LinkedList<>();
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        doctors.forEach(doctor -> {
            if(doctor.getHospital().getId() == id) {
                byHospital.add(doctor);
            }
        });
        return byHospital;
    }

    @Override
    public Optional<Doctor> findDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor;
    }

    @Override
    public Doctor saveDoctor(Doctor doctorNew) {
        if(doctorNew != null) {
            return doctorRepository.save(doctorNew);
        }
        return new Doctor();
    }

    @Override
    public String deleteDoctor(Long id) {
        if(doctorRepository.findById(id).isPresent()){
            doctorRepository.deleteById(id);
            return "Doctor has been deleted";
        }
        return "Error! The Doctor does not exist";
    }

    @Override
    public String updateDoctor(Doctor doctorNew) {
        Long num = doctorNew.getId();
        if(doctorRepository.findById(num).isPresent()) {
            Doctor doctorToUpdate = new Doctor();
            doctorToUpdate.setId(num);
            doctorToUpdate.setName(doctorNew.getName());
            doctorRepository.save(doctorNew);
            return "Doctor has been updated";
        }
        return "Error! Cannot update the doctor";
    }
}
