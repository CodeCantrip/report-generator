package io.github.codecantrip.reportgenerator.dto;

import java.util.UUID;

public class NivDto extends ModalityDto {
    private String nivMode;
    private String nivSettings;
    private String nivFrequency;

    public NivDto(){

    }

    public NivDto(String nivMode, String nivSettings, String nivFrequency){
        this.nivMode = nivMode;
        this.nivSettings = nivSettings;
        this.nivFrequency = nivFrequency;
    }

    public String getNivMode() {
        return nivMode;
    }

    public String getNivSettings() {
        return nivSettings;
    }

    public String getNivFrequency() {
        return nivFrequency;
    }
}
