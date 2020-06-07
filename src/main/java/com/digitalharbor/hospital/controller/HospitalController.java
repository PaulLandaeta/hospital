package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalController {
    public List<Hospital> getHospital();

    public Optional<Hospital> getHospitalById(Long id);

    public Hospital addHospital(Hospital hospital);

    public String deleteHospital(Long id);

    public String updateHospital(Hospital hospitalUpdated);
}
