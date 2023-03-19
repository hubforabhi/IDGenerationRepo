package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Enterprise", schema = "public")
@Data
public class Profession {

    @Id
    @Column(name = "FC_ENTERPRISE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFESSION_SEQUENCER")
    @SequenceGenerator(name = "PROFESSION_SEQUENCER", sequenceName = "PROFESSION_SEQUENCER")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private ID customerId;

    @Column(name = "FC_FIRM_NAME", length = 50)
    private String firmName;
    @Column(name = "FC_DEPARTMENT", length = 25)
    private String department;
    @Column(name = "FC_PROFESSION", length = 25)
    private String proffession;
    @Column(name = "FC_DESIGNATION", length = 25)
    private String designation;
    @Column(name = "FC_EMPLOYEE_ID", length = 25)
    private String employeeID;
    @Column(name = "FC_EMP_NAME", length = 50)
    private String empName;
    @Column(name = "FC_RANK", length = 50)
    private String rank;
    @Column(name = "FC_DIVISION", length = 50)
    private String division;
    @Column(name = "FC_PLACE_OF_WORKING", length = 50)
    private String placeOfWorking;
    @Column(name = "FC_PASS_OR_DL_NO", length = 50)
    private String expired;
    @Column(name = "FC_MEMBERSHIP_TYPE", length = 50)
    private String membershipType;

    @Column(name = "FC_BASIC_PAY", columnDefinition = "NUMERIC(14,2)")
    private BigDecimal basicPay;

    @Column(name = "FC_BILL_LIMIT", length = 50)
    private Integer billLimit;
    @Column(name = "FC_MEMBERSHIP_NO", length = 50)
    private Integer membershipNo;

    @Column(name = "FC_ENTERED_DATE")
    private LocalDate enteredDate;
    @Column(name = "FC_TRANSACTION_DATE")
    private LocalDate transactionDate;
    @Column(name = "FC_DETAILS_FROM_DATE")
    private LocalDate detailsFromDate;
    @Column(name = "FC_DETAILS_TO_DATE")
    private LocalDate detailsToDate;
    @Column(name = "FC_APPOINTMENT_DATE")
    private LocalDate appointmentDate;
    @Column(name = "FC_RETIREMENT_DATE")
    private LocalDate retirementDate;

    //private LocalDate fromDate;
    //private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FC_ENTERED_BY")
    private User enteredBy;

    @Version
    @Column(name = "FC_VERSION_ID", nullable = false)
    private Integer versionID;

    //private Integer previousVersionID;
}
