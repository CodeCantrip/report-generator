package io.github.codecantrip.reportgenerator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.OneToMany;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;

@Entity


public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID patientId;

    @OneToMany(mappedBy = "patient")
    private List<Modality> modalities = new ArrayList<>();

    private String room;
    private String unitFloor;
    private String name;
    private LocalDate dob;
    private String codeStatus;
    private String diagnosis;

    public Patient(){

    }

    public Patient(String room, String unitFloor, String name, LocalDate dob, String codeStatus, String diagnosis){
        this.room = room;
        this.unitFloor = unitFloor;
        this.name = name;
        this.dob = dob;
        this.codeStatus = codeStatus;
        this.diagnosis = diagnosis;
    }


    public UUID getPatientId(){
        return patientId;
    }

    public String getRoom(){
        return room;
    }

    public void setRoom(String room){
        this.room = room;
    }

    public String getUnitFloor(){
        return unitFloor;
    }

    public void setUnitFloor(String unitFloor){
        this.unitFloor = unitFloor;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalDate getDob(){
        return dob;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public String getCodeStatus(){
        return codeStatus;
    }

    public void setCodeStatus( String codeStatus){
        this.codeStatus = codeStatus;
    }

    public String getDiagnosis(){
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }

    public List<Modality> getModalities(){
        return modalities;
    }

}

