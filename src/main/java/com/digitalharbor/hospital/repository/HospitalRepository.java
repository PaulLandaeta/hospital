package com.digitalharbor.hospital.repository;

import com.digitalharbor.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends  JpaRepository<Hospital, Long> {
    Void save(Optional<Hospital> hospitalToUpdate);
}
