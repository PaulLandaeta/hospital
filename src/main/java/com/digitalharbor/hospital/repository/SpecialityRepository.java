package com.digitalharbor.hospital.repository;

import com.digitalharbor.hospital.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
    Void save(Optional<Speciality> specialityOptional);
}
