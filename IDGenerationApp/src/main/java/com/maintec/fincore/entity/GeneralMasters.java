package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "GENERAL_MASTERS", schema = "public")
@Data
public class GeneralMasters {

    @Id
    @Column(name = "FC_GENERAL_MASTERS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERAL_MASTERS_SEQUENCER")
    @SequenceGenerator(name = "GENERAL_MASTERS_SEQUENCER", sequenceName = "GENERAL_MASTERS_SEQUENCER")
    private Long id;

    @Column(name = "FC_DESCRIPTION",length = 50, nullable = false)
    private String description;

    @Column(name = "FC_MASTER_TYPES",length = 50, nullable = false)
    private String masterType;

    @Column(name = "FC_SOFT_DELETE")
    private LocalDateTime softDelete;

    @Column(name = "FC_EXPIRY_REASON")
    private String expiryReason;
}
