package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    public List<Hospital> findAllHospital();

    public Optional<Hospital> findHospitalById(Long id);

    public Hospital saveHospital(Hospital hospitalNew);

    public String deleteHospital(Long id);

    public String updateHospital(Hospital hospitalNew);
}
