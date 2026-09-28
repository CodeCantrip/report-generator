package io.github.codecantrip.reportgenerator.repository;

import io.github.codecantrip.reportgenerator.entity.Modality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModalityRepository extends JpaRepository<Modality, UUID> {
}
