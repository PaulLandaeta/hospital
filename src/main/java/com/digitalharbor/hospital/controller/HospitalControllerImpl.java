package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Hospital;
import com.digitalharbor.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class HospitalControllerImpl implements HospitalController {
    @Autowired
    HospitalService hospitalService;

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Hospital> getHospital() {
        return hospitalService.findAllHospital();
    }

    @RequestMapping(value = "/hospital/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    @CrossOrigin
    public Optional<Hospital> getHospitalById(@PathVariable("id") Long id) {
        return hospitalService.findHospitalById(id);
    }

    @RequestMapping(value = "/hospital/add", method = RequestMethod.POST, consumes="application/json" ,produces = "application/json")
    @Override
    public Hospital addHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }

    //TODO: use delete method just for testing *get*
    @RequestMapping(value = "/hospital/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String deleteHospital(Long id) {
        return hospitalService.deleteHospital(id);
    }

    @Override
    @RequestMapping(value = "/hospital/update", method = RequestMethod.PATCH, produces = "application/json")
    public String updateHospital(Hospital hospitalUpdated) {
        return hospitalService.updateHospital(hospitalUpdated);
    }
}
