package io.github.codecantrip.reportgenerator.dto;

import java.util.UUID;

public class TrachDto extends ModalityDto{
    private String trachType;
    private Double trachSize;

    public TrachDto(){

    }

    public TrachDto(String trachType, Double trachSize){
        this.trachType = trachType;
        this.trachSize = trachSize;
    }

    public String getTrachType() {
        return trachType;
    }

    public Double getTrachSize() {
        return trachSize;
    }
}
