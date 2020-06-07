package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface SpecialityController {
    public List<Speciality> getSpeciality();

    public Optional<Speciality> getSpecialityById(Long id);

    public Speciality addSpeciality(Speciality speciality);

    public String deleteSpeciality(Long id);

    public String updateSpeciality(Speciality specialityUpdated);
}
