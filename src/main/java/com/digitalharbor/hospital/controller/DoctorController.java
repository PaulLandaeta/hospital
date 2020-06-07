package com.digitalharbor.hospital.controller;


import com.digitalharbor.hospital.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorController {
    public List<Doctor> getDoctor();

    public Optional<Doctor> getDoctorById(Long id);

    public Doctor addDoctor(Doctor doctor);

    public String deleteHospital(Long id);

    public String updateDoctor(Doctor doctorUpdated);
}
