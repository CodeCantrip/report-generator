package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;

@Entity
public class Cpt extends Modality {
    private String therapyType;
    private String cptFrequency;

    public Cpt(){
    }

    public Cpt(String therapyType, String cptFrequency) {
        this.therapyType = therapyType;
        this.cptFrequency = cptFrequency;
    }

    public String getTherapyType(){
        return therapyType;
    }

    public void setTherapyType(String therapyType){
        this.therapyType = therapyType;
    }

    public String getCptFrequency(){
        return cptFrequency;
    }

    public void setCptFrequency(String cptFrequency){
        this.cptFrequency = cptFrequency;
    }
}