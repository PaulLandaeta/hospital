package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Speciality;
import com.digitalharbor.hospital.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
public class SpecialityControllerImpl implements SpecialityController {
    @Autowired
    SpecialityService specialityService;

    @RequestMapping(value = "/specialities", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Speciality> getSpeciality() {
        return specialityService.findAllSpeciality();
    }

    @RequestMapping(value = "/speciality/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Speciality> getSpecialityById(Long id) {
        return specialityService.findSpecialityById(id);
    }

    @RequestMapping(value = "/specialty/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Speciality addSpeciality(@RequestBody Speciality speciality) {
        return specialityService.saveSpeciality(speciality);
    }

    @RequestMapping(value = "/speciality/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String deleteSpeciality(Long id) {
        return specialityService.deleteSpeciality(id);
    }

    @RequestMapping(value = "/speciality/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updateSpeciality(Speciality specialityUpdated) {
        return specialityService.updateSpeciality(specialityUpdated);
    }
}
