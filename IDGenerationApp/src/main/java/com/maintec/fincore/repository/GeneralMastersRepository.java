package com.maintec.fincore.repository;

import com.maintec.fincore.entity.GeneralMasters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneralMastersRepository extends JpaRepository<GeneralMasters, Long> {

    Optional<GeneralMasters> findByDescription(String description);
}
