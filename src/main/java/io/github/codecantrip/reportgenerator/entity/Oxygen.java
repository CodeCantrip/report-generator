package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;

@Entity
public class Oxygen extends Modality {
    private String oxygenDevice;
    private String oxygenSetting;

    public Oxygen(){

    }

    public Oxygen(String oxygenDevice, String oxygenSetting){
        this.oxygenDevice = oxygenDevice;
        this.oxygenSetting = oxygenSetting;
    }

    public String getOxygenDevice() {
        return oxygenDevice;
    }

    public void setOxygenDevice(String oxygenDevice){
        this.oxygenDevice = oxygenDevice;
    }

    public String getOxygenSetting(){
        return oxygenSetting;
    }
    public void setOxygenSetting(String oxygenSetting) {
        this.oxygenSetting = oxygenSetting;
    }


}
