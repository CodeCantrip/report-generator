package io.github.codecantrip.reportgenerator.dto;

import java.util.UUID;

public class CptDto extends ModalityDto{
    private String therapyType;
    private String cptFrequency;

    public CptDto(){
    }

    public CptDto(String therapyType, String cptFrequency) {
        this.therapyType = therapyType;
        this.cptFrequency = cptFrequency;
    }

    public String getTherapyType() {
        return therapyType;
    }

    public String getCptFrequency() {
        return cptFrequency;
    }
}
