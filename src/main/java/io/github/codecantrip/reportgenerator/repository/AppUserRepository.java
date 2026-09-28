package io.github.codecantrip.reportgenerator.repository;
import io.github.codecantrip.reportgenerator.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    Optional<AppUser>findByUsername(String username);
}
