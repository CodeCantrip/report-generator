package io.github.codecantrip.reportgenerator.dto;

import java.util.UUID;

public class VentDto extends ModalityDto{
    private String ventMode;
    private String ventSettings;

    public VentDto(){

    }

    public VentDto(String ventMode, String ventSettings){
        this.ventMode = ventMode;
        this.ventSettings = ventSettings;
    }

    public String getVentMode() {
        return ventMode;
    }

    public String getVentSettings() {
        return ventSettings;
    }
}
