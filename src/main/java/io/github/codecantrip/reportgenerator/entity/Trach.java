package io.github.codecantrip.reportgenerator.entity;

import jakarta.persistence.Entity;

@Entity
public class Trach extends Modality {
    private String trachType;
    private Double trachSize;

    public Trach(){

    }

    public Trach(String trachType, Double trachSize){
        this.trachType = trachType;
        this.trachSize = trachSize;
    }

    public String getTrachType(){
        return trachType;
    }

    public void setTrachType(String trachType){
        this.trachType = trachType;
    }

    public Double getTrachSize(){
        return trachSize;
    }

    public void setTrachSize(Double trachSize){
        this.trachSize = trachSize;
    }
}
