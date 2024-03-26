package com.email.in.repository;

import com.email.in.model.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmailConfigRepository extends JpaRepository<EmailConfig, Long> {
    Optional<EmailConfig> findAllByMailConfigId(String mailConfigId);
}
