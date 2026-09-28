package io.github.codecantrip.reportgenerator.dto;

import java.util.UUID;

public class OxygenDto extends ModalityDto {
    private String oxygenDevice;
    private String oxygenSetting;

    public OxygenDto(){

    }

    public OxygenDto(String oxygenDevice, String oxygenSetting){
        this.oxygenDevice = oxygenDevice;
        this.oxygenSetting = oxygenSetting;
    }

    public String getOxygenDevice() {
        return oxygenDevice;
    }

    public String getOxygenSetting() {
        return oxygenSetting;
    }
}
