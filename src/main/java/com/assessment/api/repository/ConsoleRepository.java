package com.assessment.api.repository;

import com.assessment.api.entity.Console;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<Console, Integer> {
}
