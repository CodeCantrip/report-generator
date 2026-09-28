package io.github.codecantrip.reportgenerator.dto;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PatientReportDto {
    private List<ModalityDto> modalities = new ArrayList<>();
    private UUID patientId;
    private String room;
    private String unitFloor;
    private String name;
    private LocalDate dob;
    private String codeStatus;
    private String diagnosis;

    public PatientReportDto(){

    }

    public PatientReportDto(UUID patientId, String room, String unitFloor, String name, LocalDate dob, String codeStatus, String diagnosis){
        this.patientId = patientId;
        this.room = room;
        this.unitFloor = unitFloor;
        this.name = name;
        this.dob = dob;
        this.codeStatus = codeStatus;
        this.diagnosis = diagnosis;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getRoom() {
        return room;
    }

    public String getUnitFloor() {
        return unitFloor;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public List<ModalityDto> getModalities(){
        return modalities;
    }
}
