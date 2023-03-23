package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "ADDERESS", schema = "public")
@Data
public class Address {

    @Id
    @Column(name = "FC_ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQUENCER")
    @SequenceGenerator(name = "ADDRESS_SEQUENCER", sequenceName = "ADDRESS_SEQUENCER")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ID_ADDRESS")
    private ID customerId;

    @Column(name = "FC_ADD_TYPE", length = 50, nullable = false)
    private String addressType;
    @Column(name = "FC_NUM_CROSS_MAIN", length = 50)
    private String noCrossMain;
    @Column(name = "FC_AREA_LOCATION", length = 50)
    private String areaLocation;
    @Column(name = "FC_BLOCK_PHASE_STAGE", length = 50)
    private String blockPhaseStage;
    @Column(name = "FC_LANDMARK", length = 50)
    private String landMark;
    @Column(name = "FC_HOBLI", length = 50)
    private String hobli;

    @Column(name = "FC_VILLAGE", length = 50)
    private String village;
    @Column(name = "FC_TOWN", length = 50)
    private String town;
    @Column(name = "FC_CITY", length = 50)
    private String city;
    @Column(name = "FC_TALUK", length = 50)
    private String taluk;

    @Column(name = "FC_DISTRICT", length = 50)
    private String district;
    @Column(name = "FC_STATE", length = 50)
    private String state;
    @Column(name = "FC_COUNTRY", length = 50)
    private String country;
    @Column(name = "FC_PIN_CODE", length = 10)
    private String pin;

    @Column(name = "FC_LAND_LINE", length = 50)
    private String landLine;
    @Column(name = "FC_MOBILE", length = 50)
    private String mobile;
    @Column(name = "FC_FAX", length = 50)
    private String fax;

    @Column(name = "FC_WEB_ADD", length = 100)
    private String webAddress;
    @Column(name = "FC_EMAIL", length = 50)
    private String email;

    @Column(name = "FC_COMMUNICATION_ADDRESS", length = 50)
    private Boolean communication;

    @Column(name = "FC_ENTERED_DATE", nullable = false)
    private LocalDate enteredDate;
    @Column(name = "FC_FROM_DATE", nullable = false)
    private LocalDate fromDate;
    @Column(name = "FC_TO_DATE", nullable = false)
    private LocalDate toDate;
    //private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
