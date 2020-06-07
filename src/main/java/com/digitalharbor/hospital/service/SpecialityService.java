package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface SpecialityService {
    public List<Speciality> findAllSpeciality(Long id);

    public Optional<Speciality> findSpecialityById(Long id);

    public Speciality saveSpeciality(Speciality specialityNew);

    public String deleteSpeciality(Long id);

    public String updateSpeciality(Speciality specialityNew);
}
