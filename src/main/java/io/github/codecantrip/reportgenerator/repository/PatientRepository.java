package io.github.codecantrip.reportgenerator.repository;

import io.github.codecantrip.reportgenerator.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
