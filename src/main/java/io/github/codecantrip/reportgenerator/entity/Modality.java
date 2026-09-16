package io.github.codecantrip.reportgenerator.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Modality {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID modalityId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Modality() {

    }

    public UUID getModalityId() {
        return modalityId;
    }

    public Patient getPatientId(){
        return patient;
    }

    public void Patient (Patient patient){
        this.patient= patient;
    }
}
