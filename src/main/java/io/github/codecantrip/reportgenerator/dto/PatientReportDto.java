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
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String codeStatus;
    private String diagnosis;

    public PatientReportDto(){

    }

    public PatientReportDto(UUID patientId, String room, String unitFloor, String firstName, String lastName, LocalDate dob, String codeStatus, String diagnosis){
        this.patientId = patientId;
        this.room = room;
        this.unitFloor = unitFloor;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() { return lastName; }

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
