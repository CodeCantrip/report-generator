package io.github.codecantrip.reportgenerator.dto;

import java.util.UUID;

public class MedicationDto extends ModalityDto{
    private String medicationName;
    private String medFrequency;

    public MedicationDto(){

    }

    public MedicationDto(String medicationName, String medFrequency){
        this.medicationName = medicationName;
        this.medFrequency = medFrequency;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getMedFrequency() {
        return medFrequency;
    }
}
