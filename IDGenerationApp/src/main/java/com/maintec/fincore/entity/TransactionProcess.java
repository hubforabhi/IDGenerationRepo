package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;

@Embeddable
@Data
public class TransactionProcess {

   private String txnSource;

   @OneToOne
   @JoinColumn(name = "FC_FIRST_APPROVED_BY")
   private User firstApprovedBy;

   @OneToOne
   @JoinColumn(name = "FC_SECOND_APPROVED_BY")
   private User secondApprovedBy;

   @OneToOne
   @JoinColumn(name = "FC_DENIED_BY")
   private User deniedBy;

   @Column(name = "FC_FIRST_APPROVED_DATE")
   private LocalDate firstApprovedDate;

   @Column(name = "FC_SECOND_APPROVED_DATE")
   private LocalDate secondApprovedDate;

   @Column(name = "FC_DENIED_DATE")
   private LocalDate deniedDate;

   @Column(name = "FC_EXCE_REASON_ENTRY")
   private String entryExceptionalReason;

   @Column(name = "FC_EXCE_REASON_FIRST_APPROVE")
   private String firstApproveExceptionalReason;

   @Column(name = "FC_EXCE_REASON_SECOND_APPROVE")
   private String secondApproveExceptionalReason;

   @Column(name = "FC_DENIED_REASON")
   private String deniedReason;

   @Column(name = "approval_reason")
   private String approvalReason;

   @Column(name = "FC_TXN_STATUS")
   private Integer transactionStatus;

   @Column(name = "FC_EXCEPTIONAL")
   private boolean exceptional;

   @Column(name = "FC_APPROVED")
   private boolean txnApproved;
}
