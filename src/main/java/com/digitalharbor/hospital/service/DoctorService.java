package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public List<Doctor> findAllDoctor();

    public Optional<Doctor> findDoctorById(Long id);

    public Doctor saveDoctor(Doctor doctorNew);

    public String deleteDoctor(Long id);

    public String updateDoctor(Doctor doctorNew);
}
