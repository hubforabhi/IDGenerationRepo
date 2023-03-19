package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Telephone", schema = "public")
@Data
public class TelePhoneDetails {

    @Id
    @Column(name = "FC_Tele_Phone_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tele_Phone_SEQUENCER")
    @SequenceGenerator(name = "Tele_Phone_SEQUENCER", sequenceName = "Tele_Phone_SEQUENCER")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private ID customerId;

    @Column(name = "FC_NUM_PHONE_TYPE", length = 50)
    private String phoneType;

    @Column(name = "FC_ACC_NO", length = 50)
    private String accNo;

    @Column(name = "FC_CANCELLING_REASON", length = 50)
    private String cancellingReason;

    @Column(name = "FC_PHONE_NO", length = 50)
    private Long phoneNo;

    @Column(name = "FC_SMS")
    private Boolean forsms;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "FC_FROM_DATE")
    private LocalDateTime fromDate;

    @Column(name = "FC_TO_DATE")
    private LocalDateTime toDate;

    //private String status;
    //private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
