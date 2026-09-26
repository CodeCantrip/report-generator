package io.github.codecantrip.reportgenerator.service;


import io.github.codecantrip.reportgenerator.dto.*;
import io.github.codecantrip.reportgenerator.entity.*;
import io.github.codecantrip.reportgenerator.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private ModalityDto convertModality(Modality modality) {
        if (modality instanceof Vent vent) {
            return new VentDto(
                    vent.getVentMode(),
                    vent.getVentSettings()
            );
        } else if (modality instanceof Cpt cpt) {
            return new CptDto(
                    cpt.getTherapyType(),
                    cpt.getCptFrequency()
            );
        } else if (modality instanceof Ett ett) {
            return new EttDto(
                    ett.getEttSize(),
                    ett.getEttPlacement()
            );
        } else if (modality instanceof Medication medication) {
            return new MedicationDto(
                    medication.getMedicationName(),
                    medication.getMedFrequency()
            );

        } else if (modality instanceof Oxygen oxygen) {
            return new OxygenDto(
                    oxygen.getOxygenDevice(),
                    oxygen.getOxygenSetting()
            );
        } else if (modality instanceof Niv niv) {
            return new NivDto(
                    niv.getNivMode(),
                    niv.getNivSettings(),
                    niv.getNivFrequency()
            );

        } else if (modality instanceof Trach trach) {
            return new TrachDto(
                    trach.getTrachType(),
                    trach.getTrachSize()
            );
        }

        else {
            throw new IllegalArgumentException("Unknown modality type");
        }


}


    public List<PatientReportDto> getRespiratoryPatientsByUnitFloor(String unitFloor) {
        List<Patient> patients = patientRepository.findByUnitFloorAndModalitiesIsNotEmpty(unitFloor);
        List<PatientReportDto> patientReportDto = new ArrayList<>();
        for (Patient patient : patients) {
            PatientReportDto dto = new PatientReportDto(


                    patient.getPatientId(),
                    patient.getRoom(),
                    patient.getUnitFloor(),
                    patient.getName(),
                    patient.getDob(),
                    patient.getCodeStatus(),
                    patient.getDiagnosis()
            );


            for (Modality modality : patient.getModalities()){
                ModalityDto modalityDto = convertModality(modality);
                    dto.getModalities().add(modalityDto);
                }


            patientReportDto.add(dto);
        }

        return patientReportDto;
    }



}
