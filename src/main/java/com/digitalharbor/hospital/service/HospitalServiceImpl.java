package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Hospital;
import com.digitalharbor.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> findAllHospital() {
        return hospitalRepository.findAll();
    }

    @Override
    public Optional<Hospital> findHospitalById(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return hospital;
    }

    @Override
    public Hospital saveHospital(Hospital hospitalNew) {
        if(hospitalNew != null) {
            return hospitalRepository.save(hospitalNew);
        }
        return new Hospital();
    }

    @Override
    public String deleteHospital(Long id) {
        if(hospitalRepository.findById(id).isPresent()) {
            hospitalRepository.deleteById(id);
            return  "Hospital has been deleted";
        }
        return "Error! The Hospital does not exist";
    }

    @Override
    public String updateHospital(Hospital hospitalUpdated) {
        Long num = hospitalUpdated.getId();
        if(hospitalRepository.findById(num).isPresent()) {
            Hospital hospitalToUpdate = new Hospital();
            hospitalToUpdate.setId(hospitalUpdated.getId());
            hospitalToUpdate.setName(hospitalUpdated.getName());
            hospitalRepository.save(hospitalToUpdate);
            return "Hospital has been updated";
        }
        return "Error! Cannot update the Hospital";
    }
}
