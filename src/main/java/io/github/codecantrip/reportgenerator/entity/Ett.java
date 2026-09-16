package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;

@Entity
public class Ett extends Modality {
    private Double ettSize;
    private String ettPlacement;


    public Ett() {

    }

    public Ett(Double ettSize, String ettPlacement){
        this.ettPlacement = ettPlacement;
        this.ettSize = ettSize;
    }

    public Double getEttSize(){
        return ettSize;
    }

    public void setEttSize(Double ettSize){
        this.ettSize = ettSize;
    }

    public String getEttPlacement(){
        return ettPlacement;
    }

    public void setEttPlacement(String ettPlacement) {
        this.ettPlacement = ettPlacement;
    }

}