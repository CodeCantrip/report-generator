package io.github.codecantrip.reportgenerator.controller;


import io.github.codecantrip.reportgenerator.entity.Patient;
import io.github.codecantrip.reportgenerator.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {
    private final PatientService patientService;

    public PatientController (PatientService patientService){
        this.patientService = patientService;
    }
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

}
