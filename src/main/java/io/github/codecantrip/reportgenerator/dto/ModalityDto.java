package io.github.codecantrip.reportgenerator.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public abstract class ModalityDto {
    private UUID modalityId;

    public ModalityDto(){}

    public ModalityDto(UUID modalityId){
        this.modalityId = modalityId;
    }

    @JsonIgnore
    public UUID getModalityId() {
        return modalityId;
    }
}
