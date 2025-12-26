package org.example.expert.domain.log.repository;

import org.example.expert.domain.log.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Logs, Long> {
}
