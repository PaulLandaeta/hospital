package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Doctor;
import com.digitalharbor.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class DoctorControllerImpl implements DoctorController{

    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Doctor> getDoctor(@PathVariable("id") Long id) {
        return doctorService.findAllDoctors(id);
    }

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorService.findDoctorById(id);
    }

    @RequestMapping(value = "/doctor/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @RequestMapping(value = "/doctor/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String deleteHospital(Long id) {
        return doctorService.deleteDoctor(id);
    }

    @RequestMapping(value = "/doctor/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updateDoctor(Doctor doctorUpdated) {
        return doctorService.updateDoctor(doctorUpdated);
    }
}
