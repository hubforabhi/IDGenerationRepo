package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PENDING_TABLE", schema = "public")
@Data
public class TransactionPendingTray {

   @Id
   @Column(name = "FC_ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PENDING_SEQUENCER")
   @SequenceGenerator(name = "PENDING_SEQUENCER", sequenceName = "PENDING_SEQUENCER")
   private Long id;

   private Integer versionID;
   private Integer previousVersionID;
   private String refNumber;
   private String tableClassName;
   private String linkURL;
   private String processDescription;
   private String reason;
   private boolean expired;
   private boolean exceptional;
   private boolean master;
   private boolean committed;
   private Integer status;

   @OneToOne
   @JoinColumn(name = "FC_ENTERED_BY")
   private User enteredBy;

   @OneToOne
   @JoinColumn(name = "FC_FIRST_APPROVED_BY")
   private User firstApprovedBy;

   @OneToOne
   @JoinColumn(name = "FC_SECOND_APPROVED_BY")
   private User secondApprovedBy;

   @OneToOne
   @JoinColumn(name = "FC_DENIED_BY")
   private User deniedBy;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "FC_BRANCH")
   private Branch branch;

   private LocalDate enteredDate;
   private BigDecimal balanceBeforeTxn;

}
