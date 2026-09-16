package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;

@Entity
public class Vent extends Modality {
    private String ventMode;
    private String ventSettings;

    public Vent(){

    }

    public Vent(String ventMode, String ventSettings){
        this.ventMode = ventMode;
        this.ventSettings = ventSettings;
    }

    public String getVentMode(){
        return ventMode;
    }

    public void setVentMode(String ventMode){
        this.ventMode = ventMode;
    }

   public String getVentSettings(){
        return ventSettings;
   }

    public void setVentSettings(String ventSettings){
        this.ventSettings = ventSettings;
    }
}
