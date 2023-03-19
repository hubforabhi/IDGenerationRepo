package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Email", schema = "public")
@Data
public class Company {
    @Id
    @Column(name = "FC_EMAILDETAILS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_SEQUENCER")
    @SequenceGenerator(name = "EMAIL_SEQUENCER", sequenceName = "EMAIL_SEQUENCER")
    private Long id;

    @Column(name = "FC_FIRM_NAME", length = 25)
    private String firmName;
    @Column(name = "FC_ACTIVITY_NATURE", length = 25)
    private String activityNature;
    @Column(name = "FC_IT_WARD_CIRCLE", length = 25)
    private String ITWardcircle;
    @Column(name = "FC_REG_NO", length = 25)
    private String registrationNo;
    @Column(name = "FC_REG_PLACE", length = 25)
    private String registrationPlace;
    @Column(name = "FC_KST_NO", length = 25)
    private String KSTNo;
    @Column(name = "FC_EST_NO", length = 25)
    private String ESTNo;
    @Column(name = "FC_PAN", length = 25)
    private String PAN;

    @Column(name = "FC_REG_DATE")
    private LocalDate registrationDate;
    @Column(name = "FC_ENTERED_DATE", nullable = false)
    private LocalDate enteredDate;
    @Column(name = "FC_CREATION_DATE")
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
