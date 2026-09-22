package io.github.codecantrip.reportgenerator.service;


import io.github.codecantrip.reportgenerator.entity.Patient;
import io.github.codecantrip.reportgenerator.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
    this.patientRepository = patientRepository;
    }

    public List<Patient> getRespiratoryPatientsByUnitFloor(String unitFloor){
        return patientRepository.findByUnitFloorAndModalitiesIsNotEmpty(unitFloor);
    }

}
