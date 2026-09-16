package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;

@Entity
public class Medication extends Modality {
    private String medicationName;
    private String medFrequency;

    public Medication(){

    }

    public Medication(String medicationName, String medFrequency){
        this.medicationName = medicationName;
        this.medFrequency = medFrequency;
    }

    public String getMedicationName(){
        return medicationName;
    }

    public void setMedicationName(String medicationName){
        this.medicationName = medicationName;
    }

    public String getMedFrequency(){
        return medFrequency;
    }

    public void setMedFrequency(String medFrequency){
        this.medFrequency = medFrequency;
    }
}
