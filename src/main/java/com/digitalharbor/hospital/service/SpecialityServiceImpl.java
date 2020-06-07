package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Speciality;
import com.digitalharbor.hospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public List<Speciality> findAllSpeciality() {
        return specialityRepository.findAll();
    }

    @Override
    public Optional<Speciality> findSpecialityById(Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        return speciality;
    }

    @Override
    public Speciality saveSpeciality(Speciality specialityNew) {
        if(specialityNew != null) {
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
