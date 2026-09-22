package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;

@Entity
public class Niv extends Modality {
    private String nivMode;
    private String nivSettings;
    private String nivFrequency;

    public Niv(){

    }

    public Niv(String nivMode, String nivSettings, String nivFrequency){
        this.nivMode = nivMode;
        this.nivSettings = nivSettings;
        this.nivFrequency = nivFrequency;
    }

    public String getNivMode(){
        return nivMode;
    }

    public void setNivMode(String nivMode){
        this.nivMode = nivMode;
    }

    public String getNivSettings(){
        return nivSettings;
    }

    public void setNivSettings(String nivSettings){
        this.nivSettings = nivSettings;

    }

    public String getNivFrequency() {
        return nivFrequency;
    }

    public void setNivFrequency(String nivFrequency){
        this.nivFrequency = nivFrequency;
    }
}

