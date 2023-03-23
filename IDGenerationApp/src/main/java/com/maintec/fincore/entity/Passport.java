package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "PASSPORT", schema = "public")
@Data
public class Passport {

    @Id
    @Column(name = "FC_PASSPORT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSPORT_SEQUENCER")
    @SequenceGenerator(name = "PASSPORT_SEQUENCER", sequenceName = "PASSPORT_SEQUENCER")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private ID customerId;

    @Column(name = "FC_PASS_OR_DL_NO", length = 50)
    private String passportORDLNo;
    @Column(name = "FC_PASS_OR_DL_TYPE", length = 50)
    private String passportORDLType;
    @Column(name = "FC_ISSUED_AT", length = 50)
    private String issuedAt;

    //private String status;

    @Column(name = "FC_ISSUED_DATE")
    private LocalDate issueDate;
    @Column(name = "FC_EXPIRED_DATE")
    private LocalDate expiryDate;
    @Column(name = "FC_CANCEL_DATE")
    private LocalDate cancelDate;
    @Column(name = "FC_ENTERED_DATE")
    private LocalDate enteredDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
