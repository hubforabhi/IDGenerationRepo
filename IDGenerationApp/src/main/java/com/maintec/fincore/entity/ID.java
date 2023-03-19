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
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "ID_TABLE", schema = "public")
@Data
@EqualsAndHashCode(exclude = {""})
public class ID {

   @Id
   @Column(name = "FC_ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCER")
   @SequenceGenerator(name = "ID_SEQUENCER", sequenceName = "ID_SEQUENCER")
   private Long id;

   @Column(name = "FC_ENTERED_DATE", nullable = false)
   private LocalDate enteredDate;

   @Column(name = "FC_CREATION_DATE", nullable = false)
   private LocalDate creationDate;

   @OneToOne
   private Caution currentCaution;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "FC_ENTERED_BY")
   private User enteredBy;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "FC_BRANCH")
   private Branch branch;

   private Long oldId;

   private TransactionProcess transactionProcess;
}
