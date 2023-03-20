package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "HISTORY_TABLE", schema = "public")
@Data
public class History {

    @Id
    @Column(name = "FC_ENTERPRISE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_HISTORY_SEQUENCER")
    @SequenceGenerator(name = "ID_HISTORY_SEQUENCER", sequenceName = "ID_HISTORY_SEQUENCER")
    private Long id;

    @Column(name = "FC_OBJECT_ID")
    private Long objId;

    @Column(name = "FC_HISTORY")
    private Serializable historyObject;

    @Column(name = "FC_CLASS_NAME", nullable = false)
    private String tableClassName;

    @Column(name = "FC_ACCESS_URL")
    private String accessURL;

    @Column(name = "FC_DATA_DATE", nullable = false)
    private LocalDate dataDate;

    @Column(name = "FC_VALID_TILL", nullable = false)
    private LocalDate validTill;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    //private Branch branch;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
