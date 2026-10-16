package io.github.codecantrip.reportgenerator.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
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
