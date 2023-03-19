package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Email", schema = "public")
@Data
public class EmailDetails {

    @Id
    @Column(name = "FC_EMAILDETAILS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_SEQUENCER")
    @SequenceGenerator(name = "EMAIL_SEQUENCER", sequenceName = "EMAIL_SEQUENCER")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private ID customerId;

    //private Long customerID;

    @Column(name = "FC_ACC_NO", length = 50)
    private Long accNo;

    @Column(name = "FC_EMAIL_ID", length = 50)
    private String emailID;

    @Column(name = "FC_CANCELLING_REASON", length = 50)
    private String cancellingReason;

    @Column(name = "FC_ENTERED_DATE")
    private LocalDate enteredDate;

    @Column(name = "FC_TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    @Column(name = "FC_FROM_DATE")
    private LocalDateTime fromDate;

    @Column(name = "FC_TO_DATE")
    private LocalDateTime toDate;

    //private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
