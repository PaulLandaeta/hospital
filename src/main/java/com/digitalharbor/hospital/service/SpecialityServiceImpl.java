package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Hospital;
import com.digitalharbor.hospital.model.Speciality;
import com.digitalharbor.hospital.repository.HospitalRepository;
import com.digitalharbor.hospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    SpecialityRepository specialityRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Speciality> findAllSpeciality(Long id) {
        List<Speciality> specialties =specialityRepository.findAll();
        List<Speciality> byHospital = new LinkedList<>();
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        specialties.forEach(speciality -> {
            if(speciality.getHospitals().contains(hospital)) {
                byHospital.add(speciality);
            }
        });
        return byHospital;
    }

    @Override
    public Optional<Speciality> findSpecialityById(Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        return speciality;
    }

    @Override
    public Speciality saveSpeciality(Speciality specialityNew) {
        Set<Hospital> hospitalSet = new HashSet<>();
        specialityNew.getHospitals().forEach((hospital) -> {
            Hospital newHospital = hospitalRepository.findById(hospital.getId()).orElse(null);
          hospitalSet.add(newHospital);
        });

        if(specialityNew != null) {
            specialityNew.setHospitals(hospitalSet);
            return specialityRepository.save(specialityNew);
        }
        return new Speciality();
    }

    @Override
    public String deleteSpeciality(Long id) {
        if(specialityRepository.findById(id).isPresent()){
            specialityRepository.deleteById(id);
            return "Speciality has been deleted";
        }
        return "Error! The Speciality does not exist";
    }

    @Override
    public String updateSpeciality(Speciality specialityNew) {
        Long num = specialityNew.getId();
        if(specialityRepository.findById(num).isPresent()) {
            Speciality specialityToUpdate = new Speciality();
            specialityToUpdate.setId(specialityNew.getId());
            specialityToUpdate.setDescription(specialityNew.getDescription());
            specialityRepository.save(specialityToUpdate);
            return "Speciality has been updated";
        }
        return "Error! Cannot update the Speciality";
    }
}
