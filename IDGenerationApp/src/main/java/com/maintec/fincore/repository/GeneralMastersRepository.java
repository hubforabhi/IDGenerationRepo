package com.maintec.fincore.repository;

import com.maintec.fincore.entity.GeneralMasters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneralMastersRepository extends JpaRepository<GeneralMasters, Long> {

    Optional<GeneralMasters> findByDescription(String description);
}
