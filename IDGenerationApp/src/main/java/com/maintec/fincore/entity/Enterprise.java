package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Enterprise", schema = "public")
@Data
public class Enterprise {

    @Id
    @Column(name = "FC_ENTERPRISE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTERPRISE_SEQUENCER")
    @SequenceGenerator(name = "ENTERPRISE_SEQUENCER", sequenceName = "ENTERPRISE_SEQUENCER")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private ID customerId;

    @Column(name = "FC_FIRM_NAME", length = 50)
    private String firmName;
    @Column(name = "FC_LICENCE_NO", length = 50)
    private String licenceNo;
    @Column(name = "FC_CLASS", length = 50)
    private String classtype;
    @Column(name = "FC_REASON", length = 50)
    private String reason;

    @Column(name = "FC_ENTERED_DATE")
    private LocalDate enteredDate;
    @Column(name = "FC_EXPIRE_DATE")
    private LocalDate expireDate;
    @Column(name = "FC_DELETED_DATE")
    private LocalDate deleteDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FC_DELETED_BY")
    private User deleteBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;
    //private Integer previousVersionID;
}
