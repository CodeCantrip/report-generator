package io.github.codecantrip.reportgenerator.dto;


import java.util.UUID;

public class EttDto extends ModalityDto{
        private Double ettSize;
        private String ettPlacement;


        public EttDto() {

        }

        public EttDto(Double ettSize, String ettPlacement){
            this.ettPlacement = ettPlacement;
            this.ettSize = ettSize;
        }

    public Double getEttSize() {
        return ettSize;
    }

    public String getEttPlacement() {
        return ettPlacement;
    }
}
