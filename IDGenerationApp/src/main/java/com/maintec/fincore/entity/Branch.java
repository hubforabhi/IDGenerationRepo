package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BRANCH")
@Data
public class Branch {

   @Id
   @Column(name = "FC_BR_MASTER_ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_SEQUENCER")
   @SequenceGenerator(name = "BRANCH_SEQUENCER", sequenceName = "BRANCH_SEQUENCER")
   private Long id;

   @Column(name = "FC_BRANCH_ID")
   private String branchId;

   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "FC_BANK_MASTER_ID")
   private Bank bankId;
}
