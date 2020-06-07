package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Doctor;
import com.digitalharbor.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctor() {
        return doctorRepository.findAll();
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
