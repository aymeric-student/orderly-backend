package com.orderly.votybe.confirmation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConfirmationRepository extends JpaRepository<Confirmation, UUID> {
}
