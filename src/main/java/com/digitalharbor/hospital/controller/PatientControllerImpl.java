package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Patient;
import com.digitalharbor.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PatientControllerImpl implements PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Patient> getPatient(@PathVariable("id") Long id) {
        return patientService.findAllPatient(id);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Patient> getPatientById(@PathVariable("id") Long id) {
        return patientService.findPatientById(id);
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @RequestMapping(value = "/patient/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String deletePatient(Long id) {
        return patientService.deletePatient(id);
    }

    @RequestMapping(value = "/patient/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updatePatient(Patient patientUpdated) {
        return patientService.updatePatient(patientUpdated);
    }
}
