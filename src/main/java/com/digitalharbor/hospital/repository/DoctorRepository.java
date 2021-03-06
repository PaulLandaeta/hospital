package com.digitalharbor.hospital.repository;

import com.digitalharbor.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Void save(Optional<Doctor> doctorOptional);
}
