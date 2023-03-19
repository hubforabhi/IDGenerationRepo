package com.maintec.fincore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDate;

@Entity
@Table(name = "CAUTION", schema = "public")
public class Caution {
   @Id
   @Column(
      name = "ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "caution_counter"
   )
   @SequenceGenerator(
      name = "caution_counter",
      sequenceName = "caution_counter"
   )
   private Long id;
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "accountID"
   )
   private ID parentID;
   @Column(
      name = "FC_CAUTION_DESC"
   )
   private String cautionDesc;
   @Column(
      name = "FC_RELEASE_DATE"
   )
   private LocalDate releaseDate;
   @Column(
      name = "FC_RELEASE_REASON"
   )
   private String releaseReson;
   @Column(
      name = "FC_ENTERED_DATE"
   )
   private LocalDate enteredDate;
   @Column(
      name = "FC_RELEASE_BY"
   )
   private Long releasedBy;
   @Column(
      name = "FC_COMPLETED"
   )
   private boolean completed;

   @Embedded
   private TransactionProcess transactionProcess;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FC_ENTERED_BY")
   private User enteredBy;

   @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
   @JoinColumn(name = "FC_PENDING_TRAY_ID")
   private TransactionPendingTray pendingTray;

   @Version
   @Column(name = "FC_VERSION_ID", nullable = false)
   private long versionID;
}
