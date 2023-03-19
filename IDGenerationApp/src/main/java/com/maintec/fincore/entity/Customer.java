package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER", schema = "public")
@Data
public class Customer {

    @Id
    @Column(name = "FC_EMAILDETAILS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_SEQUENCER")
    @SequenceGenerator(name = "EMAIL_SEQUENCER", sequenceName = "EMAIL_SEQUENCER")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "FC_CUST_FIRST_NAME", length = 50)),
            @AttributeOverride(name = "middleName", column = @Column(name = "FC_CUST_MIDDLE_NAME", length = 50)),
            @AttributeOverride(name = "lastName", column = @Column(name = "FC_CUST_LAST_NAME", length = 50)),
    })
    private NameWithInitials customerName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "FC_FATHER_FIRST_NAME", length = 50)),
            @AttributeOverride(name = "middleName", column = @Column(name = "FC_FATHER_MIDDLE_NAME", length = 50)),
            @AttributeOverride(name = "lastName", column = @Column(name = "FC_FATHER_LAST_NAME", length = 50))
    })
    private Name fatherName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "FC_MOTHER_FIRST_NAME", length = 50)),
            @AttributeOverride(name = "middleName", column = @Column(name = "FC_MOTHER_MIDDLE_NAME", length = 50)),
            @AttributeOverride(name = "lastName", column = @Column(name = "FC_MOTHER_LAST_NAME", length = 50))
    })
    private Name motherName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "FC_SPOUSE_FIRST_NAME", length = 50)),
            @AttributeOverride(name = "middleName", column = @Column(name = "FC_SPOUSE_MIDDLE_NAME", length = 50)),
            @AttributeOverride(name = "lastName", column = @Column(name = "FC_SPOUSE_LAST_NAME", length = 50))
    })
    private Name spouseName;

    @Column(name = "FC_GENDER", length = 6)
    private String gender;
    @Column(name = "FC_SALUTATION", length = 4)
    private String salutation;
    @Column(name = "FC_INITIAL", length = 2)
    private String initial;
    @Column(name = "FC_NATIONALITY", length = 15)
    private String nationality;
    @Column(name = "FC_BLOOD_GROUP", length = 15)
    private String bloodGroup;
    @Column(name = "FC_RELEGION", length = 15)
    private String relegion;
    @Column(name = "FC_CASTE", length = 50)
    private String caste;
    @Column(name = "FC_HANDICAPPED", length = 60)
    private String handicapped;
    @Column(name = "FC_QUALIFICATION", length = 50)
    private String qualification;
    @Column(name = "FC_PAN", length = 50)
    private String PAN;
    @Column(name = "FC_MEM_TYPE", length = 25)
    private String memberType;
    @Column(name = "FC_MEM_NO", length = 25)
    private String memberNumber;
    @Column(name = "FC_SIG_LANG", length = 25)
    private String signatureLanguage;
    @Column(name = "FC_ID_MARK")
    private String identificationMark;

    @Column(name = "FC_MARRIED")
    private boolean married;
    @Column(name = "FC_SCST")
    private boolean scst;
    @Column(name = "staff", columnDefinition = "BOOLEAN default false")
    private boolean staff;

    @Column(name = "FC_AADHAAR", length = 12)
    private Long aadhaar;

    @Column(name = "FC_DOB")
    private LocalDate dateOfBirth;
    @Column(name = "FC_FAX")
    private LocalDate enteredDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_BRANCH")
    private Branch branch;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
